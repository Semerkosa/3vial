import { useState} from 'react';
import Button from '../components/Button';
import CurrencyDropDown from '../components/CurrencyDropDown';
import Providers from '../components/Providers/Providers';

import { BALANCES_URL } from '../ApplicationVariables';
import AuthConsumer from '../authentication';

const Balances = () => {
    const { token} = AuthConsumer();
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
                    balances: balanceData.balances != null
                        ?   balanceData.balances.map((balance) => {
                                return {
                                    balanceAmount: {
                                        amount: balance.balanceAmount.amount,
                                        currency: balance.balanceAmount.currency,
                                        amountInWantedCurrency: balance.balanceAmount.amountInWantedCurrency
                                    }
                                };
                            })
                        :   []
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
        <div className='o-page-content-wrapper'>
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
