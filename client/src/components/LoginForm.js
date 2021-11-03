import Button from './Button'
import { useState } from 'react'


const LoginForm = (props) => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const emailChangeHandler = (e) => {
        setEmail(e.target.value);
    }

    const passwordChangeHandler = (e) => {
        setPassword(e.target.value);
    }

    const submitHandler = async event => {
        event.preventDefault();

        props.onLogin(email, password)
    }

    return (
        <form onSubmit={submitHandler} method="POST">
            <div>
                <h2>Login</h2>
                <p style={{ color: 'grey' }}>
                    (For the current tests email and password can be skipped. Directly click on Login button.)

                </p>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input type="text" name="email" id="email"
                        onChange={emailChangeHandler}
                        value={email} />
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input type="password" name="password" id="password"
                        onChange={passwordChangeHandler}
                        value={password} />
                </div>
                <div>
                    <Button type="submit">Login</Button>
                </div>
            </div>
        </form>
    )
}

export default LoginForm