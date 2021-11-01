import React from 'react';
import Header from './components/Header'
import Button from './components/Button'
import LoginForm from './components/LoginForm'
import { useState } from 'react';
import Providers from './components/Providers/Providers';
import CurrencyDropDown from './components/CurrencyDropDown';


const LOGIN_URL = 'http://localhost:8084/user/login';
const BALANCES_URL = 'http://localhost:8083/portfolio/balances';

const DUMMY_BALANCES = {
  userBalances: [
    {
      organizationName: 'Fibank',
      balances: [
        {
          balanceAmount: {
            amount: 2420.36,
            currency: 'GBP',
            amountInWantedCurrency: 2000.40
          }
        },
        {
          balanceAmount: {
            amount: 2420.36,
            currency: 'GBP',
            amountInWantedCurrency: 2000.20
          }
        }
      ]
    },
    {
      organizationName: 'UniCredit Bulbank',
      balances: [
        {
          balanceAmount: {
            amount: 620.00,
            currency: 'EUR',
            amountInWantedCurrency: 2230.02
          }
        }
      ]
    }
  ]
}

function App() {

  const [token, setToken] = useState('');
  const [balancesData, setBalancesData] = useState('');
  const [sampleData, setSampleData] = useState(DUMMY_BALANCES);
  const [currency, setCurrency] = useState('');


  const loginHandler = async () => {

    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' }
    };

    const response = await fetch(LOGIN_URL, requestOptions);
    var tokenString = response.headers.get('token');
    setToken(tokenString);
  }

  const balancesHandler = async () => {

    const requestOptions = {
      method: 'GET',
      headers: { 'token': token }
    };

    let urlBalancesCurrencyRequest = BALANCES_URL + "?currency=" + currency;

    await fetch(urlBalancesCurrencyRequest, requestOptions)
      .then((response) => response.json())
      .then((responseJSON) => {
        setBalancesData(responseJSON);
        // ToDo: Change sampleData to balancesData when portfolio provides the structure
        setSampleData({...sampleData, wantedCurrency: currency});
      });

  }

  const selectCurrencyHandler = selectedCurrency => {
    setCurrency(selectedCurrency);
  }

  return (
    <div className="App">
      {(token === '') ? (
        <div>
          <Header />
          <LoginForm onLogin={loginHandler} />
        </div>
      ) : (
        <div>
          <h1>Get Balances <CurrencyDropDown onSelectCurrency={selectCurrencyHandler}/></h1>
          <Button type="button" onClick={balancesHandler}>Get Balances</Button>
          {/* ToDo: Change sampleData to balancesData when portfolio provides the structure */}
          {balancesData !== '' && <Providers items={sampleData.userBalances} wantedCurrency={sampleData.wantedCurrency}/>}
        </div>
      )}
    </div>

  );
}



export default App;
