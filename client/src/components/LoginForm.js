import Button from './Button'
import { useState } from 'react'


const LoginForm = (props) => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const submitHandler = async event => {
        event.preventDefault();

        props.onLogin()
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
                        onChange={e => setEmail(e.target.value)}
                        value={email} />
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input type="password" name="password" id="password"
                        onChange={e => setPassword(e.target.value)}
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