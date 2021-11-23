import Button from '../components/Button';
import SourceTypesDropDown from '../components/SourceTypesDropDown';
import CountriesDropDown from '../components/CountriesDropDown';
import BanksDropDown from '../components/BanksDropDown';
import { useState, useContext, useEffect } from 'react';
import { UserContext } from '../App';
import { PROVIDER_API_KEYS } from '../ApplicationVariables';

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
        if(token!==''){
          fetchProviderNames();  
        }
    }, [token]);
    const addNewSourceHandler = (e) => {
        console.log(source);
    };

    const selectSourceHandler = (sourceType) => {
        setSource(sourceType);
    };

    const selectCountryHandler = (selectedCountry) => {
        setCountry(selectedCountry);
    };

    const selectBankHandler = (selectedBank) => {
        setBankValue(selectedBank);
    };

    return (
        <>
            <ol>
                {providers.map(provider => (<li key={provider}>{provider}</li>))}
            </ol>
            <SourceTypesDropDown onSelectSourceType={selectSourceHandler}></SourceTypesDropDown>
            {source === 'Bank' && <CountriesDropDown onSelectCountry={selectCountryHandler} />}
            {country !== '' && <BanksDropDown countryCode={country} onSelectBank={selectBankHandler} />}
            <Button type='submit' onClick={addNewSourceHandler}>Add source</Button>
        </>
    );
};

export default Profile;
