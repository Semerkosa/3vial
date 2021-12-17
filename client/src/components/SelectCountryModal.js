import logo from '../assets/add-new-source-section/wallet.svg';
import info from '../assets/add-new-source-section/info.svg';
import AuthConsumer from '../authentication';
import { useState, useEffect } from 'react';
import { BANKS_URL } from '../ApplicationVariables';
import { NORDIGEN_COUNTRIES_URL } from '../ApplicationVariables';
const SelectCountryModal = ({ select, close }) => {
    const { token } = AuthConsumer();
    const [countries, setCountries] = useState([]);
    const [query, setQuery] = useState('');
    let textInput;


    useEffect(() => {
        async function fetchCountriesHandler() {
            try {
                const response = await fetch(NORDIGEN_COUNTRIES_URL);
                if (!response.ok) {
                    throw new Error('Something went wrong! Data could not be fetched!');
                }
                const dataInText = await response.text();
                if (dataInText.length === 0) {
                    throw new Error('No countries found!');
                }
                const data = JSON.parse(dataInText);
                console.log(data);
                const transformedCountries = data.map(country => {
                    return {
                        name: country.countryName,
                        code: country.countryCode
                    };
                });
                setCountries(transformedCountries);
            } catch (error) {
                console.log(error.message);
            }
        }
        fetchCountriesHandler();
    }, []);

    const checkQuery = (country) => {
        return query === '' || country.name.toLowerCase().includes(query.toLowerCase());
    };
    return (
        <div>
            <div className='modal' >
                <div className="source-modal-content">
                    <div className="modal-header">
                        <img src={logo} alt='header logo' />
                        <p>Please select country:</p>
                        <span className='modal-close-btn' onClick={close}>&times;</span>
                    </div>
                    <hr />
                    <div className="modal-body">
                        <div className="search-container">
                            <input ref={(input) => { textInput = input; }} onChange={event => setQuery(event.target.value)} className='modal-search-bar' type='text' placeholder="Search for country..." name="search" />
                            <button type='button'><i className="fa fa-search"></i></button>
                        </div>
                        <div className='source-btns'>
                            {countries.filter(country => checkQuery(country)).map(country => (<button type='button' onClick={() => { select(country); }} key={country.code}>
                                <img src={'https://flagcdn.com/h40/'+country.code.toLowerCase()+'.png'} alt='flag'/><span>{country.name}</span></button>))}
                        </div>
                    </div>
                    <hr />
                    <div className='modal-footer'>
                        <img src={info} alt='i' />
                        <p>Didn't see your country? <span onClick={() => textInput.focus()}>Search instead</span> </p>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default SelectCountryModal;