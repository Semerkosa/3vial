import React from 'react';
import ReactDOM from 'react-dom';
import Header from './components/Header'
import Button from './components/Button'
import LoginForm from './components/LoginForm'
import { useState } from 'react';

function App() {

  const [token, setToken] = useState('');

  const GetToken = token => {

    setToken(token);
  }

  return (
    <div className="App">
      {(token === '') ? (      
      <div>
        <Header />
        <LoginForm Login={GetToken}/>
      </div>       
        
      ) : (
        <div>
          <h1>Get Balances</h1>
          <Button text='Get Balances' onClick={onClick} />
        </div>
        
        
      )}
      
    </div>
    
  );
}

const onClick = () => {
  console.log('Clicked me')
}


export default App;
