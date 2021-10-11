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
      <Section1 />
      <Section2 />
      <Section3 />
      <Section2 />
      <Section3 />
      <Section6 />
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


class Section1 extends React.Component {
  render() {
    return (
      <>
        <section id="section-1">
          <div id="main-text">
            <h1 id="text-1">
              Managing<br /> your investments<br /> should be Trivial
            </h1>
            <p id="text-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc odio in et, lectus sit lorem id integer.
            </p>
            <EmailForm id='1' />
            <p id="text-3">
              Join the <span id="counter">324</span> people that have signed up for our early January launch. Only
              <span id="spots"> 5,000</span> spots available!
            </p>
          </div>
          <div id="circle-picture">
            <div id="circle"></div>
            <img src={group51} alt='group_51' />
          </div>
        </section>
      </>
    );
  }
}
class EmailForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: ''
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleChange(event) { this.setState({ name: event.target.value }); }
  async handleSubmit(e) {
    e.preventDefault();
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email: this.state.name })
    };
    const response = await fetch('https://reqres.in/api/posts', requestOptions);
    const data = await response.json();
    this.setState({ name: '' });
    console.log(data);
  }
  render() {
    return (<form onSubmit={this.handleSubmit} id={'form-' + this.props.id} action="/sign_up" method="POST">
      <input value={this.state.name}
        onChange={this.handleChange} type="email" id={'email-' + this.props.id} name="email" placeholder="Your email" required />
      <input type="submit" id={'submit-' + this.props.id} value="Get early access" />
    </form>);
  }
}
class Section2 extends React.Component {
  render() {
    return (
      <>
        <section id='section-2'>
          <img className="image" src={group318} alt='group_318' />
          <div>
            <h2 className="headline">
              Feature headline
            </h2>
            <p className="description">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Condimentum diam orci pretium a pharetra, feugiat cursus. Dictumst risus, sem egestas odio cras adipiscing vulputate. Nisi, risus in suscipit non. Non commodo volutpat, pharetra, vel.
            </p>
            <a className="get-started" href="/get_started">Get started <img src={vector} alt='vector' /></a>
          </div>
        </section>
      </>);
  }
}

class Section3 extends React.Component {
  render() {
    return (
      <>
        <section id='section-3'>
          <div>
            <h2 className="headline">
              Feature headline
            </h2>
            <p className="description">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Condimentum diam orci pretium a pharetra, feugiat cursus. Dictumst risus, sem egestas odio cras adipiscing vulputate. Nisi, risus in suscipit non. Non commodo volutpat, pharetra, vel.
            </p>
            <a className="get-started" href="/get_started">Get started <img src={vector} alt='vector' /></a>
          </div>
          <img className="image" src={group319} alt='group_319' />
        </section>
      </>);
  }
}

class Section6 extends React.Component {
  componentDidMount() {
    ReactDOM.render(<Footer />, document.getElementById('footer'));
  }
  render() {
    return (
      <>
        <section id="section-6">
          <EmailForm id='2' />
        </section>
      </>);
  }
}

class Footer extends React.Component {
  render() {
    return (
      <div className="footer-container">
        <p>
          © 2021 Trivial. All rights reserved
        </p>
        <div className="icons">
          <a href="https://www.instagram.com/"><img src={instagram} alt='IG' /></a>
          <a href="https://twitter.com/"><img src={twitter} alt='TW' /></a>
          <a href="https://www.facebook.com/"><img src={facebook} alt='FB' /></a>
        </div>
      </div>
    );
  }
}
export default App;
