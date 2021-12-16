import WelcomeSection from '../components/Overview/WelcomeSection';
import TotalBalanceGraph from '../components/Overview/TotalBalanceGraph';
import Notifications from '../components/Overview/Notifications';
import AddedAccounts from '../components/Overview/AddedAccounts';
import RecentTransactions from '../components/Overview/RecentTransactions';
import AddNewSourceButtonImg from '../assets/add-new-source-section/Add New Source Button.svg';
import { useEffect, useState } from 'react';
import SelectSourceTypeModal from '../components/SelectSourceTypeModal';
import SelectBankModal from '../components/SelectBankModal';
import SelectCountryModal from '../components/SelectCountryModal';

const Overview = () => {
    const [selectSourceTypeModalIsOpen, setIsSelectSourceTypeModalOpen] = useState(false);
    const [selectCountryModalIsOpen, setIsSelectCountryModalOpen] = useState(false);
    const [selectSourceModalIsOpen, setIsSelectSourceModalOpen] = useState(false);
    const [sourceType, setSourceType] = useState('');
    const [country, setCountry] = useState({});

    const selectSourceTypeHandler = (sourceType) => {
        console.log('Source type selected: ' + sourceType);
        setSourceType(sourceType);
        setIsSelectCountryModalOpen(true);
    };
    const selectCountryHandler = (country) => {
        console.log('Country selected: ' + country);
        setCountry(country);
        setIsSelectCountryModalOpen(false);
        setIsSelectSourceModalOpen(true);
    };
    const closeSelectSourceModal = () => {
        setSourceType('');
        setCountry({});
        setIsSelectSourceModalOpen(false);
        
    };
    const closeSelectCountryModal = () => {
        setSourceType('');
        setCountry({});
        setIsSelectCountryModalOpen(false);
    };

    return (
        <>
            <main className='c-overview-main'>
                <WelcomeSection />
                <section className='c-overview-main__balance-and-notifications'>
                    <div className='o-page-content-wrapper'>
                        <TotalBalanceGraph />
                        <Notifications />
                    </div>
                </section>
                <section className='c-overview-add-new-source'>
                    <div className='o-page-content-wrapper add-new-source'>
                        <h5 className='add-new-source-text'>Accounts</h5>
                        <button className={selectSourceTypeModalIsOpen ? 'add-new-source-button add-new-source-button-active' : 'add-new-source-button'}
                            onClick={()=>setIsSelectSourceTypeModalOpen(!selectSourceTypeModalIsOpen)}>
                            <img src={AddNewSourceButtonImg} alt='+' />
                            Add New Source
                            {selectSourceTypeModalIsOpen && <SelectSourceTypeModal click={selectSourceTypeHandler} />}
                        </button>
                    </div>
                </section>
                <section className='c-overview-main__accounts-and-transactions'>
                    <div className='o-page-content-wrapper'>
                        <AddedAccounts />
                        <RecentTransactions />
                    </div>
                </section>
                {selectCountryModalIsOpen && sourceType === 'Bank' && <SelectCountryModal select={selectCountryHandler} close={closeSelectCountryModal} />}
                {selectSourceModalIsOpen && sourceType === 'Bank' && country !== '' && <SelectBankModal close={closeSelectSourceModal} countryCode={country.code} />}
            </main>
        </>
    );
};

export default Overview;
