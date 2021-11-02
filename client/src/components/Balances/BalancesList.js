import BalanceItem from "./BalanceItem";

const BalancesList = (props) => {
    return (
        <ul>
            {
                // ToDo: Remove index and use something more efficient as id
                props.balances.map((balance, index) => (
                    <BalanceItem key={index} wantedCurrency={props.wantedCurrency}
                        amountInWantedCurrency={balance.balanceAmount.amountInWantedCurrency} 
                        amount={balance.balanceAmount.amount} 
                        currency={balance.balanceAmount.currency}/>
                ))
            }
        </ul>
    )
}

export default BalancesList;