import BalanceItem from "./BalanceItem";

const BalancesList = (props) => {
    return (
        <ul>
            {
                // ToDo: Remove index and use something more efficient as id
                props.balances.map((balance, index) => (
                    <BalanceItem key={index} currency={props.wantedCurrency}
                        amount={balance.balanceAmount.amountInWantedCurrency} />
                ))
            }
        </ul>
    )
}

export default BalancesList;