const BalanceItem = (props) => {

    return (
        <li>
            <div>{props.currency} {props.amount}</div>
        </li>
    );

}

export default BalanceItem;