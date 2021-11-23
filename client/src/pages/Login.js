import LoginForm from '../components/LoginForm';
import { useState, useContext } from 'react';
import { UserContext } from '../App';
import { LOGIN_URL } from '../ApplicationVariables';
import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

const Login = () => {
    let navigate = useNavigate();
    let location = useLocation();
    const { token, setToken } = useContext(UserContext);
    const [userLoginData, setUserLoginData] = useState({ email: '', password: '' });
    const loginHandler = (userEmail, userPassword) => {
        const loginRequestHandler = async (loginData) => {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(loginData)
            };
            const response = await fetch(LOGIN_URL, requestOptions);
            var tokenString = response.headers.get('User-Token');
            setToken(tokenString);
        };
        const loginData = { email: userEmail, password: userPassword };
        setUserLoginData(loginData);
        loginRequestHandler(loginData);
        if (location.state != null) {
            navigate(location.state.location.pathname.concat(location.state.location.search));
        } else {
            navigate('/');
        }
    };
    return <div>
        <LoginForm onLogin={loginHandler} />
    </div>;
};

export default Login;
