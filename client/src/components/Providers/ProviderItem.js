import Balances from "../Balances/Balances";

const ProviderItem = (props) => {
    return (
        <li>
            <div>
                <h2>{props.providerName}</h2>
            </div>
            <div>
                <h2>Balances</h2>
                <Balances balances={props.balances} wantedCurrency={props.wantedCurrency}/>
            </div>
        </li>
    )
}

export default ProviderItem;