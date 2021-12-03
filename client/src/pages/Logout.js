import { useContext, useEffect, useState } from 'react';
import { UserContext } from '../App';
import { ApplicationRoutes, LOGOUT_URL } from '../ApplicationVariables';
import { Navigate, useNavigate } from 'react-router-dom';
import { Cookies } from 'react-cookie';
const Logout = () => {
    const { token, setToken ,cookies,removeCookie} = useContext(UserContext);
    let navigate = useNavigate();
    const logout = () => {
        console.log(cookies);
        removeCookie('3vial-User-Token-Refresh');
        removeCookie('3vial-User-Token');
        setToken(null);
        navigate(ApplicationRoutes.Home_Route);
    };
    useEffect(() => {
        async function handleLogout() {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'text/plain' },
                body: token
            };
            await fetch(LOGOUT_URL, requestOptions)
                .then(response => {
                    if (response.ok) {
                        logout();
                    } else {
                        console.log('Logout response is not ok');
                    }
                })
                .catch((error) => {
                    console.log(error);
                    logout();
                });
        };
        handleLogout();
    }, [token]);


    return (
        <p>Please wait!</p>
    );
};



export default Logout;
