import { useState, useContext } from 'react';
import Button from '../components/Button';
import CurrencyDropDown from '../components/CurrencyDropDown';
import Providers from '../components/Providers/Providers';
import { UserContext } from '../App';
import { BALANCES_URL } from '../ApplicationVariables';

const Balances = () => {
    const { token, setToken } = useContext(UserContext);
    const [balancesData, setBalancesData] = useState([]);
    const [currency, setCurrency] = useState('');
    console.log(token);
    const balancesHandler = async () => {
        const requestOptions = {
            method: 'GET',
            headers: { 'User-Token': token }
        };
        let urlBalancesCurrencyRequest = BALANCES_URL + '?currency=' + currency;
        const response = await fetch(urlBalancesCurrencyRequest, requestOptions);
        const data = await response.json();
        const transformedBalances = {
            userBalances: data.userBalances.map((balanceData) => {
                return {
                    organizationName: balanceData.organizationName,
                    balances: balanceData.balances.map((balance) => {
                        return {
                            balanceAmount: {
                                amount: balance.balanceAmount.amount,
                                currency: balance.balanceAmount.currency,
                                amountInWantedCurrency: balance.balanceAmount.amountInWantedCurrency
                            }
                        };
                    })
                };
            }), wantedCurrency: currency
        };
        setBalancesData(transformedBalances);
    };
    const selectCurrencyHandler = selectedCurrency => {
        setCurrency(selectedCurrency);
    };
    return (
        <div>
            <h1>Get Balances <CurrencyDropDown onSelectCurrency={selectCurrencyHandler} /></h1>
            <Button type="button" onClick={balancesHandler}>Get Balances</Button>
            {balancesData.length !== 0 && <Providers items={balancesData.userBalances}
                wantedCurrency={balancesData.wantedCurrency} />}
        </div>
    );
};
export default Balances;
