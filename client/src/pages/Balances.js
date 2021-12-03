import { useState, useContext } from 'react';
import Button from '../components/Button';
import CurrencyDropDown from '../components/CurrencyDropDown';
import Providers from '../components/Providers/Providers';
import { UserContext } from '../App';
import { BALANCES_URL } from '../ApplicationVariables';

const Balances = () => {
    const { token, setToken } = useContext(UserContext);
    const [balancesData, setBalancesData] = useState({ userBalances: [], wantedCurrency: '' });
    const [areBalancesFetched, setAreBalancesFetched] = useState(false);
    const [currency, setCurrency] = useState('');
    const balancesHandler = async () => {
        const requestOptions = {
            method: 'GET',
            headers: { 'User-Token': token }
        };
        let urlBalancesCurrencyRequest = BALANCES_URL + '?currency=' + currency;
        const response = await fetch(urlBalancesCurrencyRequest, requestOptions);
        const data = await response.json();
        const preTransformedBalances = data.userBalances != null ? data.userBalances : [];
        const transformedBalances = {
            userBalances: preTransformedBalances.map((balanceData) => {
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
        setAreBalancesFetched(true);
    };
    const selectCurrencyHandler = selectedCurrency => {
        setCurrency(selectedCurrency);
    };
    return (
        <div>
            <h1>Get Balances <CurrencyDropDown onSelectCurrency={selectCurrencyHandler} /></h1>
            <Button type="button" onClick={balancesHandler}>Get Balances</Button>
            {balancesData.userBalances.length !== 0 &&
                <Providers items={balancesData.userBalances} wantedCurrency={balancesData.wantedCurrency} />
            }
            {(balancesData.userBalances.length === 0) && areBalancesFetched &&
                <h2>You don't have any linked accounts yet</h2>
            }
        </div>
    );
};
export default Balances;
