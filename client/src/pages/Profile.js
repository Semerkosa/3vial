import Button from '../components/Button';
import SourceTypesDropDown from '../components/SourceTypesDropDown';
import { useState } from 'react';
const Profile = () => {
    const [source, setSource] = useState('Bank');
    const addNewSourceHandler = (e) => {
        console.log(source);
     };
    const selectSourceHandler = (sourceType) => {
        setSource(sourceType);
    };
    return (
        <>
            <SourceTypesDropDown onSelectSourceType={selectSourceHandler}></SourceTypesDropDown>
            <Button type='submit' onClick={addNewSourceHandler}>Add source</Button>
        </>
    );
};

export default Profile;
