import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './authentication';
import { RequireAuth } from './components/RequireAuth';
import { ApplicationRoutes } from './ApplicationVariables';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import Login from './pages/Login';
import Register from './pages/Register';
import Balances from './pages/Balances';
import Profile from './pages/Profile';
import Overview from './pages/Overview';
import CompleteAddSource from './pages/CompleteAddSource';
import Logout from './pages/Logout';
import CookieConsentPopup from './CookieConsentPopup';

function App() {
  return (
    <AuthProvider>
      <h1>Trivial</h1>
      <Router>
        <Header />
        <Routes>
          <Route index path={ApplicationRoutes.Home_Route} element={<Home />}></Route>
          <Route path={ApplicationRoutes.Login_Route} element={<Login />} />
          <Route path={ApplicationRoutes.Register_Route} element={<Register />} />
          <Route path={ApplicationRoutes.Balances_Route} element={
            <RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
              <Balances />
            </RequireAuth>
          } />
          <Route path={ApplicationRoutes.Profile_Route} element={
            <RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
              <Profile />
            </RequireAuth>
          } />
          <Route path={ApplicationRoutes.Overview_Route} element={
            <RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
              <Overview />
            </RequireAuth>
          } />
          <Route path={ApplicationRoutes.Verify_Add_New_Source} element={
            <RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
              <CompleteAddSource />
            </RequireAuth>
          } />
          <Route path={ApplicationRoutes.Logout} element={
            <RequireAuth redirectTo={ApplicationRoutes.Login_Route}>
              <Logout />
            </RequireAuth>
          } />
          <Route path='*' element={()=>'Page not found!'}></Route>
        </Routes>
        <Footer />
      </Router>
      <CookieConsentPopup />
    </AuthProvider >
  );
}

export default App;
