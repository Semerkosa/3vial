import React from 'react';
import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, NavLink } from 'react-router-dom';
import { ApplicationRoutes } from './ApplicationVariables';
import Login from './pages/Login';
import Register from './pages/Register';
import Balances from './pages/Balances';
import Profile from './pages/Profile';

export const UserContext = React.createContext();
function App() {
  const [token, setToken] = useState('');
  return (
    <UserContext.Provider value={{ token, setToken }}>
      <h1>Trivial</h1>
      <Router>
        <nav>
        {token === '' ?
          <>
            <NavLink to={ApplicationRoutes.Register_Route}>Register</NavLink>
            <NavLink to={ApplicationRoutes.Login_Route}>Login</NavLink></> :
          <>
            <NavLink to={ApplicationRoutes.Balances_Route}>Balances</NavLink>
            <NavLink to={ApplicationRoutes.Profile_Route}>Profile</NavLink>
          </>
        }
        </nav>
        <hr/>
        <Routes>
          <Route exact path={ApplicationRoutes.Login_Route} element={<Login />} />
          <Route exact path={ApplicationRoutes.Register_Route} element={<Register />} />
          <Route exact path={ApplicationRoutes.Balances_Route} element={<Balances />} />
          <Route exact path={ApplicationRoutes.Profile_Route} element={<Profile />} />
        </Routes>
      </Router>
    </UserContext.Provider >
  );
}

export default App;
