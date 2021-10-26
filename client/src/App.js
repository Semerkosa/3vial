import React from 'react';
import ReactDOM from 'react-dom';
import Header from './components/Header'
import Button from './components/Button'

function App() {
  return (
    <div className="App">
      <Header />
      <Button text='Login' onClick={onClick}/>
      <Button text='Get Balances' onClick={onClick} />
    </div>
    
  );
}

const onClick = () => {
  console.log('Clicked me')
}


export default App;
