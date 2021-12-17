const AccountCardRow = (props) =>{

    if (props.type === 'even'){
        return  <div className='o-account-card-row-even'>

            <span className='o-account-card-row-symbol u-inter-500'>BTC</span>
            <span className='u-inter-500'>$68,383.298</span>
            <div className='o-account-card-row-percent'>
                <span className='o-account-card-row-percent-arrow'/>
                <span className='u-manrope-600'>0.62%</span>
            </div>

        </div>
    }
    else {
        return  <div className='o-account-card-row'>

            <span className='o-account-card-row-symbol u-inter-500'>BTC</span>
            <span className='u-inter-500'>$68,383.298</span>
            <div className='o-account-card-row-percent'>
                <span className='o-account-card-row-percent-arrow'/>
                <span className='u-manrope-600'>0.62%</span>
            </div>


        </div>
    }


}

export default AccountCardRow