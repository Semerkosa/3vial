import logo from './Logo-1.png';
import group51 from './Group 51.png';
import group318 from './Group 318.png';
import group319 from './Group 319.png';
import vector from './Vector.png';
import facebook from './Social Icons FB.png';
import instagram from './Social Icons IG.png';
import twitter from './Social Icons TW.png';
import endLogo from './Union.png';
import twit from './twit.png';
import './reset.css';
import './style.scss';
import React from 'react';
import ReactDOM from 'react-dom';

import { NavLink } from 'react-router-dom';
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <>
      <main>
        <Header />
        <Section1 />
        <Section2 id={2} headline='Seamless live feed from all your accounts' description='No more manual inputs. Connect to your bank, stock brokerage and crypto platforms once and get live updates with the latest state of your portfolio' />
        <Section3 id={3} headline='Secure, Private, Yours' description='Trivial will never sell or use your financial data for advertising. Your accounts and data are private, protected and encrypted at rest and in transit' />
        <Section2 id={4} headline='Unlock the power of your data' description='With all your financial data in one place, you can make better decisions to achieve your wealth goals. We will continue bringing features to help you reach financial milestones quicker, safer and smoother.' />
        <Section3 id={5} headline='Feature headline' description='Lorem ipsum dolor sit amet, consectetur adipiscing elit. Condimentum diam orci pretium a pharetra, feugiat cursus. Dictumst risus, sem egestas odio cras adipiscing vulputate. Nisi, risus in suscipit non. Non commodo volutpat, pharetra, vel.' />
        <Section6 />
      </main>
      <Footer />
    </>
  );
}
class Header extends React.Component {
  focusOnInput = () => {
    document.querySelector('input').focus();
  }
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
          <button onClick={this.focusOnInput}>Get early access</button>
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
              Unleash your wealth
            </h1>
            <p id="text-2">New-age wealth builders constantly juggle with multiple investment platforms. Making sense of the big picture is arduous when it really shouldn't be.<br /><br />
              We bring seamless order to your wealth so you can spend more time growing it.
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
      email: ''
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleChange(event) { this.setState({ email: event.target.value }); }
  async handleSubmit(e) {
    e.preventDefault();
    e.target.getElementsByTagName('input')[0].value = '';
    ReactDOM.render(<Modal email={this.state.email} />, document.getElementById('modal'));
  }
  render() {
    return (
      <form onSubmit={this.handleSubmit} id={'form-' + this.props.id} action="/sign_up" method="POST">
        <input value={this.state.email}
          onChange={this.handleChange} type="email" id={'email-' + this.props.id} name="email" placeholder="Your email" required />
        <input type="submit" id={'submit-' + this.props.id} value="Get early access" />
      </form>);
  }
}
class Section2 extends React.Component {
  render() {
    return (
      <>
        <section id={'section-' + this.props.id}>
          <img className="image" src={group318} alt='group_318' />
          <div>
            <h2 className="headline">
              {this.props.headline}
            </h2>
            <p className="description">
              {this.props.description}
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
        <section id={'section-' + this.props.id}>
          <div>
            <h2 className="headline">
              {this.props.headline}
            </h2>
            <p className="description">
              {this.props.description}
            </p>
            <a className="get-started" href="/get_started">Get started <img src={vector} alt='vector' /></a>
          </div>
          <img className="image" src={group319} alt='group_319' />
        </section>
      </>);
  }
}
class Section6 extends React.Component {
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
      <footer>
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
      </footer>
    );
  }
}
class Modal extends React.Component { render() { return; } }
let text1 = [
  'What do you hope Trivial will help you with? (Select all that apply)',
  'Seeing all my investment accounts in one place',
  'Setting clear and meaningful financial goals',
  'Making better investment decisions',
  'Getting my taxes in order',
  'Other (please specify):'
];

let text2 = [
  'What do you use to solve this problem now? (Select only one option)',
  'Nothing',
  'Spreadsheets',
  'I’ve set up my own APIs',
  'Financial advisor',
  'Dedicated software (please specify):'
];

let text3 = [
  'Please list the names of the investment platforms you use today?',
  '(some examples for the types of platforms: Traditional banks, Neobanks, Stock brokers, Crypto exchanges and others)'
];
export default App;
