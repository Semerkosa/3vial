import RegisterForm from '../components/RegisterForm';
import { ApplicationRoutes, REGISTER_URL } from '../ApplicationVariables';
import { Fragment, useState } from 'react';
import { useNavigate } from 'react-router';

const Register = () => {

    let navigate = useNavigate();
    const [userRegisterData, setUserRegisterData] = useState({ email: '', password: '' });
    const [error, setError] = useState(null);


    const registerHandler = (userEmail, userPassword) => {

        let errorMessage = '';

        const registerRequestHandler = async (registerData) => {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(registerData)
            };

            const response = await fetch(REGISTER_URL, requestOptions);

            if (!response.ok) {
                throw new Error("Registration failed!")
            }

        };

        const registerData = { email: userEmail, password: userPassword };
        setUserRegisterData(registerData);

        // This can be changed to a better approach to show errors on unsuccessful registration.
        registerRequestHandler(registerData).catch((e) => {
            errorMessage = e.message;
        }).finally(() => {
            if (errorMessage === '') {
                navigate(ApplicationRoutes.Login_Route);
            } else {
                setError(errorMessage);
            }
        });



    };


    return (
        <Fragment>
            <RegisterForm onRegister={registerHandler} />
            {error && <p style={{ color: 'red', fontSize: 12 }}>{error}</p>}
        </Fragment>

    );
};

export default Register;
