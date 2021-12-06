import { Navigate, useLocation } from 'react-router-dom';
import AuthConsumer from '../authentication';
export function RequireAuth({ children, redirectTo }) {
    const { isLoggedIn } = AuthConsumer();
    let location = { location: useLocation() };
    return isLoggedIn() ? children : <Navigate to={redirectTo} replace={true} state={location} />;
};