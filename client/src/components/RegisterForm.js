import { useState } from "react";
import Button from "./Button";

const RegisterForm = (props) => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [passwordConfirm, setPasswordConfirm] = useState('');

    const submitHandler = (e) => {
        e.preventDefault();
    }

    const emailChangeHandler = (e) => {
        setEmail(e.target.value);
    }

    const passwordChangeHandler = (e) => {
        setPassword(e.target.value);
    }

    const passwordConfirmChangeHandler = (e) => {
        setPasswordConfirm(e.target.value);
    }

    return (
        <form onSubmit={submitHandler}>
            <h2>Register</h2>
            <div>
                <label htmlFor="">Email:</label>
                <input type="email" name="email" id="email"
                    onChange={emailChangeHandler} value={email} />
            </div>
            <div>
                <label htmlFor="">Password:</label>
                <input type="password" name="password" id="password"
                    onChange={passwordChangeHandler} value={password} />
            </div>
            <div>
                <label htmlFor="">Confirm Password:</label>
                <input type="password" name="passwordConfirm" id="passwordConfirm"
                    onChange={passwordConfirmChangeHandler} value={passwordConfirm} />
            </div>
            <div>
                <Button type="submit">Register</Button>
            </div>
        </form>
    )
}

export default RegisterForm;