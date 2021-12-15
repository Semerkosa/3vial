import WelcomeSection from '../components/Overview/WelcomeSection';
import TotalBalanceGraph from '../components/Overview/TotalBalanceGraph';
import Notifications from '../components/Overview/Notifications';
import AddedAccounts from '../components/Overview/AddedAccounts';
import RecentTransactions from '../components/Overview/RecentTransactions';
import AddNewSourceButtonImg from '../assets/add-new-source-section/Add New Source Button.svg';
import { useEffect, useState } from 'react';
import AuthConsumer from '../authentication';
import SelectSourceTypeModal from '../components/SelectSourceTypeModal';
import SelectSourceModal from '../components/SelectSourceModal';

const Overview = () => {
    const { token, isLoggedIn } = AuthConsumer();
    const [selectSourceTypeModalIsOpen, setIsSelectSourceTypeModalOpen] = useState(false);
    const [selectSourceModalIsOpen, setIsSelectSourceModalOpen] = useState(false);
    const [sourceType, setSourceType] = useState('');
    const selectSourceTypeHandler = (sourceType) => {
        console.log('Source type selected: ' + sourceType);
        setSourceType(sourceType);
        setIsSelectSourceModalOpen(true);
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
                        <button className={selectSourceTypeModalIsOpen?'add-new-source-button add-new-source-button-active':'add-new-source-button'}
                            onClick={() => setIsSelectSourceTypeModalOpen(!selectSourceTypeModalIsOpen)}>
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
                {selectSourceModalIsOpen && <SelectSourceModal />}
            </main>
        </>
    );
};


export default Overview;
