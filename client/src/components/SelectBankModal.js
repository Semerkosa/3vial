import logo from '../assets/add-new-source-section/wallet.svg';
import info from '../assets/add-new-source-section/info.svg';
import AuthConsumer from '../authentication';
import { useState, useEffect } from 'react';
import { NORDIGEN_CREATE_REQUISITION_URL } from '../ApplicationVariables';
import { BANKS_URL } from '../ApplicationVariables';
const SelectBankModal = ({ close,countryCode }) => {
    const { token } = AuthConsumer();
    const [banks, setBanks] = useState([]);
    const [query, setQuery] = useState('');
    let textInput;
    useEffect(() => {
        async function fetchBanks() {
            try {
                const urlBanksInCountry = BANKS_URL + '/'+countryCode;
                const response = await fetch(urlBanksInCountry);
                if (!response.ok) {
                    throw new Error('Something went wrong! Data could not be fetched!');
                }
                const dataInText = await response.text();
                if (dataInText.length === 0) {
                    throw new Error('No banks for the selected country!');
                }
                const data = JSON.parse(dataInText);
                console.log(data);
                const transfromedBanks = data.map(bank => {
                    return {
                        name: bank.name,
                        id: bank.id,
                        logo: bank.logo
                    };
                });
                setBanks(transfromedBanks);
            } catch (error) {
                console.log(error.message);
            }
        }
        fetchBanks();
    }, []);
    const selectBankHandler = (selectedBank) => {
        async function createRequisition() {
            const requestOptions = {
                method: 'GET',
                headers: {
                    'User-Token': token,
                    'Bank-Id': selectedBank.id,
                    'Bank-Name': selectedBank.name,
                    'Redirect-Link-Prefix': 'http://localhost:3000/ui/complete_add_source'
                }
            };
            try {
                const response = await fetch(NORDIGEN_CREATE_REQUISITION_URL, requestOptions);
                if (!response.ok) {
                    throw new Error('Something went wrong. Source cannot be added.');
                }
                const data = await response.json();
                window.location = data.link;
            } catch (err) {
                console.log(err.message);
            }
        };
        if (selectedBank !== null && selectedBank !== undefined) {
            createRequisition();
        }
    };
    const checkQuery = (bank) => {
        return query === '' || bank.name.toLowerCase().includes(query.toLowerCase());
    };
    return (
        <div>
            <div className='modal' >
                <div className="source-modal-content">
                    <div className="modal-header">
                        <img src={logo} alt='header logo' />
                        <p>Banks, Stock brokerages and pension funds</p>
                        <span className='modal-close-btn' onClick={close}>&times;</span>
                    </div>
                    <hr />
                    <div className="modal-body">
                        <div className="search-container">
                            <input ref={(input) => { textInput = input; }} onChange={event => setQuery(event.target.value)} className='modal-search-bar' type='text' placeholder="Search for crypto exchanges and wallet..." name="search" />
                            <button type='button'><i className="fa fa-search"></i></button>
                        </div>
                        <div className='source-btns'>
                            {banks.filter(bank => checkQuery(bank)).map(provider => (<button type='button' onClick={() => { selectBankHandler(provider); }} key={provider.id}><img src={provider.logo} alt={provider.name} /><span>{provider.name}</span></button>))}
                        </div>
                    </div>
                    <hr />
                    <div className='modal-footer'>
                        <img src={info} alt='i' />
                        <p>Didn't see your exchange or wallet? <span onClick={() => textInput.focus()}>Search instead</span> </p>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default SelectBankModal;