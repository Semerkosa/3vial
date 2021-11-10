export const isValidEmail = (email) => {
    return email.trim() !== '' &&
        /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,})+$/.test(email);
}

export const isValidPassword = (password) => password.trim().length >= 6;

export const isEmpty = (value) => value.trim() === '';
