import { useState, useEffect } from 'react';
import { useSearchParams,useParams } from 'react-router-dom';
import { ApplicationRoutes, VERIFY_REQUSITION } from '../ApplicationVariables';
import { Navigate } from 'react-router-dom';
import AuthConsumer from '../authentication';
const CompleteAddSource = () => {
    const { token } = AuthConsumer();
    const [searchParams] = useSearchParams();
    let params = useParams();
    const referenceId = searchParams.get('ref');
    const userToken = params.token;
    const errorMessage = searchParams.get('error');
    const [message, setMessage] = useState('');
    const [redirect, setRedirect] = useState(10);
    useEffect(() => {
        async function verifyRequisition() {
            const controller = new AbortController();
            setTimeout(() => controller.abort(), 3000);
            const requestOptions = {
                method: 'GET',
                headers: { 'User-Token': userToken, 'Reference-Id': referenceId },
                signal: controller.signal
            };
            await fetch(VERIFY_REQUSITION, requestOptions)
                .then(response => {
                    if (response.ok) {
                        response.text().then((text) => setMessage(text));
                    } else {
                        setMessage('Error ' + response.status);
                        console.log(response.text());
                    }

                }).catch((error) => {
                    if (error.name === 'AbortError') {
                        alert('Request timeout exceeded! Operation aborted!');
                    } else {
                        throw error;
                    }
                });
        };
        if (errorMessage) {
            setMessage(errorMessage);
        } else {
            (token === userToken) ? verifyRequisition() : setMessage('Invalid token!');
        }

    }, []);

    useEffect(() => {
        let timer = setTimeout(() => {
            setRedirect(redirect - 1);
        }, 1000);
        return () => clearTimeout(timer);
    }, [redirect]);

    return (
        <div>
            <p>{message}</p>
            <small>You will be redirected in: {redirect}</small>
            {redirect === 0 && (<Navigate to={ApplicationRoutes.Profile_Route} replace={true} />)}
        </div>
    );
};

export default CompleteAddSource;