import { useEffect, useState } from 'react';
import { ApplicationRoutes } from '../ApplicationVariables';
import { useNavigate } from 'react-router-dom';

import AuthConsumer from '../authentication';
const Logout = () => {
    const { logout } = AuthConsumer();
    const [message, setMessage] = useState('');
    let navigate = useNavigate();
    const onSuccess = () => {
        navigate(ApplicationRoutes.Home_Route);
    };
    const onFailure = (error) => {
        setMessage(error.name + ':  ' + error.message);
    };
    useEffect(() => {
        logout(onSuccess, onFailure);
    }, []);

    return (
        <>
            {message && <p>{message}</p>}
        </>
    );
};



export default Logout;
