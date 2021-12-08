import { NavLink } from 'react-router-dom';
import { ApplicationRoutes } from '../ApplicationVariables';
import AuthConsumer from '../authentication';
const Nav = () => {
    const { isLoggedIn } = AuthConsumer();
    return (
        <>
            <nav className='navigation'>
                {isLoggedIn() ?
                    <>
                        <NavLink to={ApplicationRoutes.Balances_Route}>Balances</NavLink>
                        <NavLink to={ApplicationRoutes.Profile_Route}>Profile</NavLink>
                        <NavLink to={ApplicationRoutes.Overview_Route}>Overview</NavLink>
                        <NavLink to={ApplicationRoutes.Logout}>Logout</NavLink>
                    </>
                    :
                    <>
                        <NavLink to={ApplicationRoutes.Register_Route}>Register</NavLink>
                        <NavLink to={ApplicationRoutes.Login_Route}>Login</NavLink>
                    </>
                }
            </nav>
            <hr />
        </>);
};
export default Nav;