import { NavLink } from 'react-router-dom';
import { ApplicationRoutes } from '../ApplicationVariables';
import AuthConsumer from '../authentication';
const Nav = () => {
    const { isLoggedIn } = AuthConsumer();
    return (
        <>
            <nav className='c-navigation'>
                {isLoggedIn() ?
                    <ul>
                        <NavLink to={ApplicationRoutes.Balances_Route}>Balances</NavLink>
                        <NavLink to={ApplicationRoutes.Profile_Route}>Profile</NavLink>
                        <NavLink to={ApplicationRoutes.Overview_Route}>Overview</NavLink>
                        <NavLink to={ApplicationRoutes.Logout}>Logout</NavLink>
                    </ul>
                    :
                    <ul>
                        <NavLink to={ApplicationRoutes.Register_Route}>Register</NavLink>
                        <NavLink to={ApplicationRoutes.Login_Route}>Login</NavLink>
                    </ul>
                }
            </nav>
        </>);
};

export default Nav;
