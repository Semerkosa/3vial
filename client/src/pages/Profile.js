import Button from '../components/Button';
import SourceTypesDropDown from '../components/SourceTypesDropDown';
import CountriesDropDown from '../components/CountriesDropDown';
import BanksDropDown from '../components/BanksDropDown';
import { useState, useContext, useEffect } from 'react';
import { UserContext } from '../App';
import { PROVIDER_API_KEYS, NORDIGEN_CREATE_REQUISITION_URL } from '../ApplicationVariables';

const Profile = () => {
    const { token } = useContext(UserContext);
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
        if (token !== '') {
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
                    'Redirect-Link-Prefix': 'http://localhost:3000/ui/complete_add_source'
                }
            };

            const response = await fetch(NORDIGEN_CREATE_REQUISITION_URL, requestOptions);
            const data = await response.json();
            window.location = data.link;
        };

        if (bankValue !== null) {
            createRequisition()
        }
    };

    const selectSourceHandler = (sourceType) => {
        setSource(sourceType);
    };

    const selectCountryHandler = (selectedCountry) => {
        setCountry(selectedCountry);
    };

    const selectBankHandler = (selectedBank) => {
        setBankValue(selectedBank.value);
    };

    return (
        <>
            <ol>
                {providers.map(provider => (<li key={provider}>{provider}</li>))}
            </ol>
            <SourceTypesDropDown onSelectSourceType={selectSourceHandler}></SourceTypesDropDown>
            {source === 'Bank' && <CountriesDropDown onSelectCountry={selectCountryHandler} />}
            {country !== '' && <BanksDropDown countryCode={country} onSelectBank={selectBankHandler} />}
            {bankValue !== '' && <Button type='submit' onClick={addNewSourceHandler}>Add source</Button>}
        </>
    );
};

export default Profile;
