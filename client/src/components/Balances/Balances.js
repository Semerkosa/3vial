import BalanceItem from "./BalanceItem";
import BalancesList from "./BalancesList";

const Balances = (props) => {

    return (
        <div>
            <BalancesList balances={props.balances} wantedCurrency={props.wantedCurrency}/>
        </div>
    )
}

export default Balances