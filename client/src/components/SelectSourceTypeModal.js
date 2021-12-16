import Group33692 from '../assets/add-new-source-section/Group 33692.svg';
import Group33693 from '../assets/add-new-source-section/Group 33693.svg';
import Group33694 from '../assets/add-new-source-section/Group 33694.svg';
import Group33695 from '../assets/add-new-source-section/Group 33695.svg';
import Group33696 from '../assets/add-new-source-section/Group 33696.svg';


const SelectSourceTypeModal = ({ click }) => {
    return (
        <div>
            <div className='modal' ></div>
            <div className="clip-path"></div>
            <div className="source-type-modal-content">
                <div className='flex-container-row-center-flex-start' onClick={() => click('Bank')}>
                    <img src={Group33692} alt='' /><span>Banks, Stock brokerages and pension funds</span>
                </div>
                <hr />
                <div className='flex-container-row-center-flex-start' onClick={() => click('Crypto')}>
                    <img src={Group33693} alt='' /><span>Crypto exchanges and wallets</span>
                </div>
                <hr />
                <div className='flex-container-row-center-flex-start' onClick={() => click('Stock options')}>
                    <img src={Group33694} alt='' /><span>Company stock options</span>
                </div>
                <hr />
                <div className='flex-container-row-center-flex-start' onClick={() => click('Equity investments')}>
                    <img src={Group33695} alt='' /><span>Angel and private equity investments</span>
                </div>
                <hr />
                <div className='flex-container-row-center-flex-start' onClick={() => click('Custom')}>
                    <img src={Group33696} alt='' /><span>Custom Entry</span>
                </div>
            </div>
        </div>
    );
};

export default SelectSourceTypeModal;

