import * as React from 'react';
import { useCookies } from 'react-cookie';
import jwt_decode from 'jwt-decode';
import { getCookieConsentValue } from 'react-cookie-consent';
import { LOGIN_URL, LOGOUT_URL, REFRESH_TOKEN_URL } from './ApplicationVariables';
const authContext = React.createContext();

function useAuth() {
    const [cookies, setCookie, removeCookie] = useCookies(['3vial-User-Token']);
    const [token, setToken] = React.useState(() => {
        return cookies['3vial-User-Token'] !== undefined ? (cookies['3vial-User-Token']) : null;
    });
    const decodeTokenAndGetExpiration = (userToken) => {
        let decoded = jwt_decode(userToken);
        return decoded.exp;
    };
    const [tokenExpire, setTokenExpire] = React.useState(() => {
        if (cookies['3vial-User-Token'] !== undefined) {
            const userToken = cookies['3vial-User-Token'];
            let expiresIn = decodeTokenAndGetExpiration(userToken);
            let expiresDate = new Date(0);
            expiresDate.setUTCSeconds(expiresIn - 20);
            return expiresDate;
        }
        return null;
    });
    const setTokenCookie = (userToken, cookieName) => {
        let expiresIn = decodeTokenAndGetExpiration(userToken);
        let expiresDate = new Date(0);
        expiresDate.setUTCSeconds(expiresIn - 20);
        setTokenExpire(expiresDate);
        setCookie(cookieName, userToken, { path: '/', expires: expiresDate, sameSite: 'lax' });
    };
    const checkTokenExpiration = () => {
        if (tokenExpire > Date.now()) {
            return false;
        } else {
            return true;
        }
    };
    return {
        token,
        isTokenExpired() {
            return checkTokenExpiration();
        },
        isLoggedIn() {
            return (token !== '' && token !== null && token !== undefined);
        },
        login(loginData, onSuccess, onFailure) {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(loginData)
            };
            return fetch(LOGIN_URL, requestOptions).then((response) => {
                if (!response.ok) {
                    response.text().then((text) => {
                        let errorObject = JSON.parse(text);
                        onFailure({ name: (errorObject.status + ' ' + errorObject.error), message: errorObject.message });
                    });
                } else {
                    let userToken = response.headers.get('User-Token');
                    if (userToken === null || userToken === undefined) {
                        throw new Error('Empty token from login!');
                    }
                    setToken(userToken);
                    if (getCookieConsentValue('3vial-Cookie-Consent')) {
                        setTokenCookie(userToken, '3vial-User-Token');
                    }
                    onSuccess();
                }
            }).catch((error) => {
                console.log(error);
                onFailure(error);
            });
        },
        logout(onSuccess, onFailure) {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'text/plain' },
                body: token
            };
            return fetch(LOGOUT_URL, requestOptions)
                .then(response => {
                    if (response.ok) {
                        removeCookie('3vial-User-Token', { path: '/', domain: 'localhost' });
                        setToken(null);
                        setTokenExpire(null);
                        onSuccess();
                    } else {
                        response.text().then((text) => {
                            let errorObject = JSON.parse(text);
                            onFailure({ name: (errorObject.status + ' ' + errorObject.error), message: errorObject.message });
                        });
                    }
                })
                .catch((error) => {
                    onFailure(error);
                });
        },
        refreshToken(onSuccess,onFailure) {
            const request = new Request(REFRESH_TOKEN_URL, {
                method: 'GET',
                credentials: 'include',
            });
            return fetch(request).then((response) => {
                if (!response.ok) {
                    console.log('Failed to renew the user token from the refresh token!');
                    setToken(null);
                    return onFailure();
                } else {
                    let userToken = response.headers.get('User-Token');
                    if (userToken === null || userToken === undefined) {
                        return onFailure();
                    }
                    setToken(userToken);
                    let expiresIn = decodeTokenAndGetExpiration(userToken);
                    let expiresDate = new Date(0);
                    expiresDate.setUTCSeconds(expiresIn - 20);
                    setTokenExpire(expiresDate);
                    setTokenCookie(userToken);
                    return onSuccess();
                }
            }).catch((error) => {
                console.log(error);
                return onFailure();
            });

        }
    };
}

export function AuthProvider({ children }) {
    const auth = useAuth();

    return (
        <authContext.Provider value={auth}>
            {children}
        </authContext.Provider>
    );
}

export default function AuthConsumer() {
    return React.useContext(authContext);
}


