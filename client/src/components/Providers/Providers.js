import ProviderItem from "./ProviderItem";
import ProvidersList from "./ProvidersList";

const Providers = (props) => {
    return(
        <div>
            <ProvidersList items={props.items} wantedCurrency={props.wantedCurrency}/>
        </div>
    )
}

export default Providers;