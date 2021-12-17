import AddedAccountCard from "./AddedAccountCard";
import RecentTransactions from "./RecentTransactions";
import AuthConsumer from "../../authentication";
import {useState, useEffect} from "react";
import {BALANCES_URL} from "../../ApplicationVariables";

const AddedAccounts = () => {

    const { token} = AuthConsumer();

    const [balancesData, setBalancesData] = useState({ userBalances: [], wantedCurrency: 'BGN' });
    const balancesHandler = async () => {
        const requestOptions = {
            method: 'GET',
            headers: { 'User-Token': token }
        };
        let urlBalancesCurrencyRequest = BALANCES_URL + '?currency=' + "BGN";
        const response = await fetch(urlBalancesCurrencyRequest, requestOptions);
        const data = await response.json();
        const preTransformedBalances = data.userBalances != null ? data.userBalances : [];
        const transformedBalances = {
            userBalances: preTransformedBalances.map((balanceData) => {
                return {
                    organizationName: balanceData.organizationName,
                    balances: balanceData.balances != null
                        ? balanceData.balances.map((balance) => {
                            return {
                                balanceAmount: {
                                    amount: balance.balanceAmount.amount,
                                    currency: balance.balanceAmount.currency,
                                    amountInWantedCurrency: balance.balanceAmount.amountInWantedCurrency
                                }
                            };
                        })
                        : []
                };
            }), wantedCurrency: ""
        };
        setBalancesData(transformedBalances);
    };

    useEffect(() => {
        balancesHandler();
    }, []);

    let cards = []
    console.log( balancesData.userBalances.length)
    for (let i = 0; i < balancesData.userBalances.length; i++) {
        cards.push(<AddedAccountCard/>)
    }
    return <article className='o-accounts-wrapper'>{cards}</article>
}

export default AddedAccounts;
