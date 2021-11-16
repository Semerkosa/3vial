import Button from '../components/Button';
import SourceTypesDropDown from '../components/SourceTypesDropDown';
import { useState } from 'react';
import CountriesDropDown from '../components/CountriesDropDown';
import BanksDropDown from '../components/BanksDropDown';

const Profile = () => {
    const [source, setSource] = useState('');
    const [country, setCountry] = useState('');
    const [bankValue, setBankValue] = useState('');

    const addNewSourceHandler = (e) => {
        console.log(source);
    };

    const selectSourceHandler = (sourceType) => {
        setSource(sourceType);
    };

    const selectCountryHandler = (selectedCountry) => {
        setCountry(selectedCountry);
    }

    const selectBankHandler = (selectedBank) => {
        setBankValue(selectedBank);
    }

    return (
        <>
            <SourceTypesDropDown onSelectSourceType={selectSourceHandler}></SourceTypesDropDown>
            {source === 'Bank' && <CountriesDropDown onSelectCountry={selectCountryHandler} />}
            {country !== '' && <BanksDropDown countryCode={country} onSelectBank={selectBankHandler} />}
            <Button type='submit' onClick={addNewSourceHandler}>Add source</Button>
        </>
    );
};

export default Profile;
