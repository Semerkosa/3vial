import Button from '../components/Button';
import SourceTypesDropDown from '../components/SourceTypesDropDown';
import CountriesDropDown from '../components/CountriesDropDown';
import BanksDropDown from '../components/BanksDropDown';
import { useState, useEffect } from 'react';
import { PROVIDER_API_KEYS, NORDIGEN_CREATE_REQUISITION_URL } from '../ApplicationVariables';
import AuthConsumer from '../authentication';

const Profile = () => {
    const { token ,isLoggedIn } = AuthConsumer();
    const [source, setSource] = useState('');
    const [country, setCountry] = useState('');
    const [bankValue, setBankValue] = useState('');
    const [providers, setProviders] = useState([]);

    useEffect(() => {
        async function fetchProviderNames() {
            const requestOptions = {
                method: 'GET',
                headers: { 'User-Token': token }
            };
            const response = await fetch(PROVIDER_API_KEYS, requestOptions);
            const data = await response.json();
            const providers = data.keysOrganization.map(e => e.organizationName);
            setProviders(providers);
        };
        if (isLoggedIn()) {
            fetchProviderNames();
        }
    }, [token]);

    const addNewSourceHandler = () => {
        async function createRequisition() {
            const requestOptions = {
                method: 'GET',
                headers: {
                    'User-Token': token,
                    'Bank-Id': bankValue.value,
                    'Bank-Name': bankValue.label,
                    'Redirect-Link-Prefix': 'http://localhost:3000/ui/complete_add_source'
                }
            };

            const response = await fetch(NORDIGEN_CREATE_REQUISITION_URL, requestOptions);
            const data = await response.json();
            window.location = data.link;
        };

        if (bankValue !== null && bankValue !== undefined) {
            createRequisition();
        }
    };

    const selectSourceHandler = (sourceType) => {
        setSource(sourceType);

        if (sourceType === 'Bank') {
            setCountry('');
            setBankValue(null);
        }
    };

    const selectCountryHandler = (selectedCountry) => {
        setCountry(selectedCountry);
        setBankValue(null);
    };

    const selectBankHandler = (selectedBank) => {
        setBankValue(selectedBank);
    };

    return (
        <>
            <p>Currently connected sources:</p>
            <ol>
                {providers.map(provider => (<li key={provider}>{provider}</li>))}
            </ol>
            <SourceTypesDropDown onSelectSourceType={selectSourceHandler}></SourceTypesDropDown>
            {source === 'Bank' && <CountriesDropDown onSelectCountry={selectCountryHandler} />}
            {source === 'Bank' && country !== '' && <BanksDropDown countryCode={country} onSelectBank={selectBankHandler} />}
            {source === 'Bank' && country !== '' && bankValue !== null && <Button type='submit' onClick={addNewSourceHandler}>Add source</Button>}
        </>
    );
};

export default Profile;
