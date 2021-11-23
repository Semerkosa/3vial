import React from 'react';
import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, NavLink, Navigate } from 'react-router-dom';
import { ApplicationRoutes } from './ApplicationVariables';
import Login from './pages/Login';
import Register from './pages/Register';
import Balances from './pages/Balances';
import Profile from './pages/Profile';

export const UserContext = React.createContext();
function App() {
  const [token, setToken] = useState('');
  let isLoggedIn = () => token !== '';
  return (
    <UserContext.Provider value={{ token, setToken }}>
      <h1>Trivial</h1>
      <Router>
        <nav>
          {isLoggedIn() ?
            <>
              <NavLink to={ApplicationRoutes.Balances_Route}>Balances</NavLink>
              <NavLink to={ApplicationRoutes.Profile_Route}>Profile</NavLink>
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
          <Route path={ApplicationRoutes.Login_Route} element={!isLoggedIn() ? <Login />
            : <Navigate to={ApplicationRoutes.Balances_Route} replace={true} />} />
          <Route path={ApplicationRoutes.Register_Route} element={!isLoggedIn() ? <Register />
            : <Navigate to={ApplicationRoutes.Balances_Route} replace={true} />} />
          <Route path={ApplicationRoutes.Balances_Route} element={isLoggedIn() ? <Balances />
            : <Navigate to={ApplicationRoutes.Login_Route} replace={true} />} />
          <Route path={ApplicationRoutes.Profile_Route} element={isLoggedIn() ? <Profile />
            : <Navigate to={ApplicationRoutes.Login_Route} replace={true} />} />
        </Routes>
      </Router>
    </UserContext.Provider >
  );
}

export default App;
