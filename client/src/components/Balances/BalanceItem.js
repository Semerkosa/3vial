const BalanceItem = (props) => {

    return (
        <li>
            <div>{props.currency} {props.amount} {'-->'} {props.wantedCurrency} {props.amountInWantedCurrency}</div>
        </li>
    );

}

export default BalanceItem;