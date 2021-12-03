import React  from 'react';
import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, NavLink, Navigate, useLocation } from 'react-router-dom';
import { ApplicationRoutes } from './ApplicationVariables';
import Login from './pages/Login';
import Register from './pages/Register';
import Balances from './pages/Balances';
import Profile from './pages/Profile';
import CompleteAddSource from './pages/CompleteAddSource';
import Home from './pages/Home';
import Logout from './pages/Logout';
import CookieConsentPopup from './CookieConsentPopup';
import { Cookies, useCookies } from 'react-cookie';

export const UserContext = React.createContext();
function App() {
  const [cookies, setCookie, removeCookie] = useCookies(['3vial-User-Token','3vial-User-Token-Refresh']);
  const [token, setToken] = useState(() => {
    console.log(cookies['3vial-User-Token']);
    if (cookies['3vial-User-Token'] !== undefined) {
      return (cookies['3vial-User-Token']);
    }
    return null;
  });
  const isLoggedIn = () => {
    return (token !== '' && token !== null);
  };
  function RequireAuth({ children, redirectTo }) {
    let location = { location: useLocation() };
    return isLoggedIn() ? children : <Navigate to={redirectTo} replace={true} state={location} />;
  }

  return (
    <UserContext.Provider value={{ token, setToken, cookies, setCookie, removeCookie }}>
      <h1>Trivial</h1>
      <Router>
        <nav>
          {isLoggedIn() ?
            <>
              <NavLink to={ApplicationRoutes.Balances_Route}>Balances</NavLink>
              <NavLink to={ApplicationRoutes.Profile_Route}>Profile</NavLink>
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
        <Routes>
          <Route index path={ApplicationRoutes.Home_Route} element={<Home />}></Route>
          <Route path={ApplicationRoutes.Login_Route} element={!isLoggedIn() ? <Login />
            : <Navigate to={ApplicationRoutes.Balances_Route} replace={true} />} />
          <Route path={ApplicationRoutes.Register_Route} element={!isLoggedIn() ? <Register />
            : <Navigate to={ApplicationRoutes.Balances_Route} replace={true} />} />
          <Route path={ApplicationRoutes.Balances_Route} element={<RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
            <Balances /></RequireAuth>} />
          <Route path={ApplicationRoutes.Profile_Route} element={<RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
            <Profile /></RequireAuth>} />
          <Route path={ApplicationRoutes.Verify_Add_New_Source} element={<RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
            <CompleteAddSource /></RequireAuth>} />
          <Route path={ApplicationRoutes.Logout} element={<RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
            <Logout /></RequireAuth>} />
        </Routes>
      </Router>
      <CookieConsentPopup />
    </UserContext.Provider >
  );
}

export default App;
