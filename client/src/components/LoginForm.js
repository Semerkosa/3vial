import Button from './Button';
import useInput from '../hooks/use-input';
import { isValidEmail, isValidPassword, isEmpty } from '../utils/formValidationRules';
import { useState } from 'react';


const LoginForm = (props) => {

    const [isSubmitClicked, setIsSubmitClicked] = useState(false);

    const {
        value: enteredEmail,
        isValid: enteredEmailIsValid,
        hasError: emailInputHasError,
        changeHandler: enteredEmailChangeHandler,
        blurHandler: enteredEmailBlurHandler
    } = useInput(isValidEmail);

    const {
        value: enteredPassword,
        isValid: enteredPasswordIsValid,
        hasError: passwordInputHasError,
        changeHandler: enteredPasswordChangeHandler,
        blurHandler: enteredPasswordBlurHandler
    } = useInput(isValidPassword);

    let formIsValid = false;


    if (enteredEmailIsValid && enteredPasswordIsValid) {
        formIsValid = true;
    }

    const submitHandler = async event => {
        event.preventDefault();

        setIsSubmitClicked(true);

        if (!formIsValid) {
            return;
        }

        props.onLogin(enteredEmail, enteredPassword)
    }

    return (
        <form onSubmit={submitHandler} method="POST">
                <h2>Login</h2>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input type="email" name="email" id="email"
                        onChange={enteredEmailChangeHandler}
                        onBlur={enteredEmailBlurHandler}
                        value={enteredEmail}
                    />
                    {emailInputHasError &&
                        <p style={{ color: 'red', fontSize: 12 }}>Please enter a valid e-mail address!</p>}
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input type="password" name="password" id="password"
                        onChange={enteredPasswordChangeHandler}
                        onBlur={enteredPasswordBlurHandler}
                        value={enteredPassword}
                    />
                    {passwordInputHasError &&
                        <p style={{ color: 'red', fontSize: 12 }}>Password must be at least 6 characters long!</p>}
                </div>
                {isSubmitClicked && isEmpty(enteredEmail) && isEmpty(enteredPassword) &&
                    <p style={{ color: 'red', fontSize: 12 }}>Input fields cannot be empty!</p>}
                <Button type="submit">Login</Button>
        </form>
    )
}

export default LoginForm