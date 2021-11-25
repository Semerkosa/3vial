import React from 'react';
import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, NavLink, Navigate, useLocation } from 'react-router-dom';
import { ApplicationRoutes } from './ApplicationVariables';
import Login from './pages/Login';
import Register from './pages/Register';
import Balances from './pages/Balances';
import Profile from './pages/Profile';
import CompleteAddSource from './pages/CompleteAddSource';
import Home from './pages/Home';

export const UserContext = React.createContext();
function App() {
  const [token, setToken] = useState('');
  let isLoggedIn = () => token !== '' && token !== null;
  function RequireAuth({ children, redirectTo }) {
    let location = { location: useLocation() };
    return isLoggedIn() ? children : <Navigate to={redirectTo} replace={true} state={location} />;
  }
  return (
    <UserContext.Provider value={{ token, setToken }}>
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
          <Route path={ApplicationRoutes.Logout} />
        </Routes>
      </Router>
    </UserContext.Provider >
  );
}

export default App;
