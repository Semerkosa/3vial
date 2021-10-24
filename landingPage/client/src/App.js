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
  constructor(props){
    super(props);
    this.state={counter:-1};
  }
  componentDidMount(){
     fetch('http://localhost:8080/count').then(response => response.json())
     .then(data => this.setState({ counter: data}));
  }
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
              Join the <span id="counter">{this.state.counter}</span> people that have signed up for our early January launch. Only
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
class Modal extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      view: 0,
      progress: 25,
      email: props.email,
      result: [new Array(5).fill(false), '', ''],
      textInput: new Array(2).fill('')
    };
  }
  close = () => {
    ReactDOM.unmountComponentAtNode(document.getElementById('modal'));
  }
  handleNext = () => {
    this.setState({
      progress: this.state.progress + 25,
      view: this.state.view + 1
    });
    if (this.state.view === 2) {
      this.handleFinish();
    }
  }
  handleBack = () => {
    this.setState({
      progress: this.state.progress - 25,
      view: this.state.view - 1
    });
  }
  handleFinish = async () => {
    const finalResult = {
      email: this.state.email,
      answers_1: this.state.result[0].map((e, i) => e === true ? i : '').filter(String),
      answer_2:this.state.result[1],
      answer_3:this.state.result[2],
      text_input_1:this.state.textInput[0],
      text_input_2:this.state.textInput[1]
    };
    console.log(finalResult);
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json'},
      body: JSON.stringify(finalResult)
    };
    const response = await fetch('http://localhost:8080/sign_up', requestOptions);
    const data = await response.json();
    console.log(data);
  }
  handleChange = (e) => {
    let editState = {
      copyState: () => ({ progress: this.state.progress, result: this.state.result }),
      0: function () {
        newState.result[0][e] = !newState.result[0][e];
        this.updateProgress(newState.result[0].includes(true));
      },
      1: function () {
        newState.result[1] = newState.result[1] === e ? '' : e;
        this.updateProgress(newState.result[1] !== '');
      },
      2: function () {
        newState.result[2] = e;
        this.updateProgress(newState.result[2] !== '');
      },
      updateProgress: (i) => {
        if (this.state.progress < (this.state.view + 1) * 50 && i) {
          newState.progress = newState.progress + 25;
        } else if (this.state.progress > (this.state.view + 1) * 50 - 25 && !i) {
          newState.progress = newState.progress - 25;
        }
      }
    };
    let newState = editState.copyState();
    editState[this.state.view]();
    this.setState(newState);
  }
  handleTextInput = (e) => {
    let newInput = Array.from(this.state.textInput);
    newInput[this.state.view] = e;
    this.setState({ textInput: newInput });
  }
  render() {
    if (this.state.view === 3) {
      return (
        <>
          <div className='modal'>
            <div className="modal-content">
              <div className="modal-header">
                <span className="close-btn" onClick={this.close}>&times;</span>
              </div>
              <div className='thank-you'>
                <img id='logo' src={endLogo} alt='logo' />
                <h1>Thanks for supporting us!</h1>
                <p>Don’t forget to tell your friends and keep your eyes peeled for the launch! 🚀</p>
                <a href='https://twitter.com/'><img src={twit} alt='twitter icon' />Follow us on Twitter</a>
              </div>
            </div>
          </div>
        </>
      );
    }
    return (
      <>
        <div className='modal'>
          <div className="modal-content">
            <div className="modal-header">
              <span className="close-btn" onClick={this.close}>&times;</span>
              <h1>Help us make Trivial more useful for you</h1>
              <progress id="progress" value={this.state.progress} max="150"></progress>
            </div>
            <Questionnaire state={this.state.result[this.state.view]} type={this.state.view === 0 ? 'checkbox' : 'radio'}
              view={this.state.view} handleNext={this.handleNext} handleBack={this.handleBack}
              updateProgress={this.updateProgress} handleChange={this.handleChange} handleTextInput={this.handleTextInput}
              result={this.state.result} textInput={this.state.textInput}
              text={this.state.view === 0 ? text1 : (this.state.view === 1 ? text2 : text3)} />
          </div>
        </div>
      </>
    );
  }
}
class Questionnaire extends React.Component {
  handleChange = (event) => {
    this.props.handleChange(event.target.value);
  }
  handleNext = () => {
    this.props.handleNext();
  }
  handleBack = () => {
    this.props.handleBack();
  }
  shouldBeDisabled = () => {
    if (this.props.view === 0) {
      return !this.props.result[0].includes(true);
    } else {
      return this.props.result[this.props.view] === '';
    }
  }
  isChecked = (index) => {
    if (this.props.view === 0) {
      return this.props.result[0][index];
    } else {
      return this.props.result[this.props.view] === index;
    }
  }
  handleTextInput = (e) => {
    this.props.handleTextInput(e.target.value);
  }
  render() {
    return (
      <>
        <div className="modal-body">
          <p>{this.props.text[0]}</p>
          {this.props.view !== 2 ?
            <>
              <form id="survey">
                <input type={this.props.type} checked={this.isChecked('0')} id="option-1" name="option" value="0" onChange={this.handleChange} />
                <label htmlFor="option-1">{this.props.text[1]}</label>
                <input type={this.props.type} checked={this.isChecked('1')} id="option-2" name="option" value="1" onChange={this.handleChange} />
                <label htmlFor="option-2">{this.props.text[2]}</label>
                <input type={this.props.type} checked={this.isChecked('2')} id="option-3" name="option" value="2" onChange={this.handleChange} />
                <label htmlFor="option-3">{this.props.text[3]}</label>
                <input type={this.props.type} checked={this.isChecked('3')} id="option-4" name="option" value="3" onChange={this.handleChange} />
                <label htmlFor="option-4">{this.props.text[4]}</label>
                <input type={this.props.type} checked={this.isChecked('4')} id="option-5" name="option" value="4" onChange={this.handleChange} />
                <label htmlFor="option-5">{this.props.text[5]}<input id="text-input" type='text' value={this.props.textInput[this.props.view]} disabled={!this.isChecked('4')} onChange={this.handleTextInput} /></label>
              </form>
            </> : <>
              <label id='eg' htmlFor='textarea'>(some examples for the types of platforms: Traditional banks, Neobanks, Stock brokers, Crypto exchanges and others)</label>
              <textarea onChange={this.handleChange} id='textarea' mame='textarea' placeholder='...' maxLength='300' value={this.props.result[2]}></textarea>
            </>}
        </div>
        <hr id='line' />
        <div className="modal-footer">
          <button type="button" disabled={this.props.view === 0 ? true : false} onClick={this.handleBack}>Back</button>
          <button type="submit" disabled={this.shouldBeDisabled()} onClick={this.handleNext}>{this.props.view !== 2 ? 'Next' : 'Finish'}</button>
        </div>
      </>
    );
  }
}

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