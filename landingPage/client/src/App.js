import logo from './Logo-1.png';
import group51 from './Group 51.png';
import group318 from './Group 318.png';
import group319 from './Group 319.png';
import vector from './Vector.png';
import facebook from './Social Icons FB.png';
import instagram from './Social Icons IG.png';
import twitter from './Social Icons TW.png';
import './reset.css';
import './style.scss';
import React from 'react';
import ReactDOM from 'react-dom';

import { NavLink } from 'react-router-dom';
import { BrowserRouter } from 'react-router-dom';


function App() {
  return (
    <>
      <Header />
    </>
  );
}
class Header extends React.Component {
  render() {
    return (
      <>
        <header>
          <img id="logo" src={logo} alt="logo" />
          <BrowserRouter>
            <nav className="nav">
              <NavLink exact id='home' to='/' activeClassName="active"> Home</NavLink>
              <NavLink id='features' to='/features'  >Features</NavLink>
              <NavLink id='contact' to='/contact'  >Contact</NavLink>
            </nav>
          </BrowserRouter>
          <button>Get early access</button>
        </header>
        <hr />
      </>);
  }
}

export default App;
