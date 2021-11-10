import Button from "./Button";
import useInput from "../hooks/use-input";
import { isValidEmail, isValidPassword, isEmpty } from "../utils/formValidationRules";

import { useState } from "react";

const RegisterForm = (props) => {

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

    const {
        value: enteredPasswordConfirm,
        isValid: enteredPasswordConfirmIsValid,
        hasError: passwordConfirmInputHasError,
        changeHandler: enteredPasswordConfirmChangeHandler,
        blurHandler: enteredPasswordConfirmBlurHandler
    } = useInput(isValidPassword);

    const isPasswordMatching = enteredPassword === enteredPasswordConfirm;

    let formIsValid = false;


    if (enteredEmailIsValid &&
        enteredPasswordIsValid &&
        enteredPasswordConfirmIsValid && isPasswordMatching) {

        formIsValid = true;
    }

    const submitHandler = (e) => {
        e.preventDefault();

        setIsSubmitClicked(true);

        if (!formIsValid) {
            return;
        }
    }

    return (
        <form onSubmit={submitHandler}>
            <h2>Register</h2>
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
            <div>
                <label htmlFor="passwordConfirm">Confirm Password:</label>
                <input type="password" name="passwordConfirm" id="passwordConfirm"
                    onChange={enteredPasswordConfirmChangeHandler}
                    onBlur={enteredPasswordConfirmBlurHandler}
                    value={enteredPasswordConfirm}
                />
                {
                    (passwordConfirmInputHasError ||
                        (!isEmpty(enteredPasswordConfirm) && !isPasswordMatching)) &&
                    <p style={{ color: 'red', fontSize: 12 }}>Passwords do not match!</p>
                }
            </div>
            {isSubmitClicked && isEmpty(enteredEmail) && isEmpty(enteredPassword) && isEmpty(enteredPasswordConfirm) &&
                <p style={{ color: 'red', fontSize: 12 }}>Input fields cannot be empty!</p>}
            <div>
                <Button type="submit">Register</Button>
            </div>
        </form>
    )
}

export default RegisterForm;