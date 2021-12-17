import AccountCardRow from "./AccountCardRow";


const AddedAccountCard = () =>{


    // logoStyle.replace("logo",props.organizationName)
    return (<div className='o-account-card'>

        <div className='o-account-card-title'>

            <span className='o-account-card-title-logo'/>
            <span className='u-inter-600'>$2,428.42</span>
            <div className='o-account-card-title-percent'>
                <span className='o-account-card-title-percent-arrow'/>
                <span className='u-inter-600'>2.05%</span>
            </div>

        </div>

        <AccountCardRow type = "odd" />
        <AccountCardRow type = "even"/>
        <AccountCardRow type = "odd"/>
        <AccountCardRow type = "even"/>

        <section className='o-account-card-expand'>
            <button className='o-account-card-expand-button u-inter-600'>Expand</button>
            <span className='o-account-card-expand-arrow'/>
        </section>

    </div>
    )

}

export default AddedAccountCard;