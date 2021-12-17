import LoginForm from '../components/LoginForm';
import { useState } from 'react';
import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import AuthConsumer from '../authentication';

const Login = () => {
    let navigate = useNavigate();
    let location = useLocation();
    const { login } = AuthConsumer();
    const [userLoginData, setUserLoginData] = useState({ email: '', password: '' });
    const [message, setMessage] = useState('');
    const loginHandler = (userEmail, userPassword) => {
        const loginData = { email: userEmail, password: userPassword };
        setUserLoginData(loginData);
        let redirect = location.state ? location.state.location.pathname.concat(location.state.location.search) : '/';
        const onSuccess = () => {
            return navigate(redirect);
        };
        const onFailure = (error) => {
          setMessage(error.name + ':  ' + error.message);
        };
        login(loginData, onSuccess, onFailure);
    };
    return <div className='o-page-content-wrapper'>
        {message && <p>{message}</p>}
        <LoginForm onLogin={loginHandler} />
    </div>;
};

export default Login;
