import WelcomeSection from '../components/Overview/WelcomeSection';
import TotalBalanceGraph from '../components/Overview/TotalBalanceGraph';
import Notifications from '../components/Overview/Notifications';
import AddedAccounts from '../components/Overview/AddedAccounts';
import RecentTransactions from '../components/Overview/RecentTransactions';

const Overview = () => {
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
                <section className='c-overview-main__accounts-and-transactions'>
                    <div className='o-page-content-wrapper'>
                        <h5>Accounts + Add New Source</h5>
                        <AddedAccounts />
                        <RecentTransactions />
                    </div>
                </section>
            </main>
        </>
    );
}

export default Overview;
