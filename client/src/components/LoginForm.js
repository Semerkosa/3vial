import Button from './Button'
import { useState } from 'react'

const LoginForm = ({Login}) => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type' : 'application/json'}
    };

    const submitHandler = async e => {
        e.preventDefault();     

        const response = await fetch('http://localhost:8084/user/login', requestOptions);
        var tokenString = response.headers.get('token');
        Login(tokenString)
        console.log(tokenString);
    }

    return(
        <form onSubmit={submitHandler} method="POST">
            <div>
                <h2>Login</h2>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input type="text" name="email" id="email"
                    onChange = {e => setEmail(e.target.value)}
                    value = {email} />
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input type="password" name="password" id="password"
                    onChange = {e => setPassword(e.target.value)}
                    value = {password} />
                </div>
                <div>
                    <Button text='Login'/>
                </div>
            </div>
        </form>
    )
}

export default LoginForm