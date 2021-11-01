import ProviderItem from "./ProviderItem";

const ProvidersList = (props) => {
    return(
        <ul>
            {
                // ToDo: Remove index and use something more efficient as id
                props.items.map((provider, index) => (
                    <ProviderItem key={index} providerName={provider.organizationName} balances={provider.balances} 
                    wantedCurrency={props.wantedCurrency}/>
                ))
            }
        </ul>
    )
}

export default ProvidersList;