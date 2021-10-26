import React from 'react';
import ReactDOM from 'react-dom';

function App() {
  return (
    <BalancesButton />
  );
}

class BalancesButton extends React.Component {
  render() {
    return (
      <button>Get balances</button>
    );
  }
}

export default App;
