import LoginForm from '../components/LoginForm';
import { useState, useContext } from 'react';
import { UserContext } from '../App';
import { LOGIN_URL } from '../ApplicationVariables';
import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { getCookieConsentValue } from 'react-cookie-consent';
import jwt_decode from 'jwt-decode';
import { Cookies } from 'react-cookie';

const Login = () => {
    let navigate = useNavigate();
    let location = useLocation();
    const { token, setToken } = useContext(UserContext);
    const [userLoginData, setUserLoginData] = useState({ email: '', password: '' });
    const [message, setMessage] = useState('');
    const loginHandler = (userEmail, userPassword) => {
        const decodeTokenAndGetExpiration = (userToken) => {
            let decoded = jwt_decode(userToken);
            return decoded.exp;
        };
        const setTokenCookie = (userToken, cookieName) => {
            let expiresIn = decodeTokenAndGetExpiration(userToken);
            let expiresDate = new Date();
            expiresDate.setTime(expiresDate.getTime() + (expiresIn * 1000));
            let cookies = new Cookies();
            cookies.set(cookieName, userToken, { path: '/', expires: expiresDate, sameSite: 'lax' });
        };
        const loginRequestHandler = async (loginData) => {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(loginData)
            };
            return await fetch(LOGIN_URL, requestOptions).then((response) => {
                if (!response.ok) {
                    response.text().then((text) => setMessage('Message: ' + text));
                } else {
                    let userToken = response.headers.get('User-Token');
                    let refreshToken = response.headers.get('User-Token-Refresh');
                    console.log(userToken);
                    console.log(refreshToken);
                    if (userToken === null || refreshToken ===null ||userToken===undefined||refreshToken===undefined) {
                        throw new Error('Empty token from login!');
                    }
                    setToken(userToken);
                    if (getCookieConsentValue('3vial-Cookie-Consent')) {
                        setTokenCookie(refreshToken, '3vial-User-Token-Refresh');
                        setTokenCookie(userToken, '3vial-User-Token');
                    }
                    if (location.state) {
                        navigate(location.state.location.pathname.concat(location.state.location.search));
                    } else {
                        navigate('/');
                    }
                }
            }).catch((error) => {
                setMessage(error.name + ':  ' + error.message);
            });
        };
        const loginData = { email: userEmail, password: userPassword };
        setUserLoginData(loginData);
        loginRequestHandler(loginData);
    };
    return <div>
        <p>{message}</p>
        <LoginForm onLogin={loginHandler} />
    </div>;
};

export default Login;
