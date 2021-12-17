import { useCallback, useEffect, useState, Fragment, useRef } from "react";
import Select from "react-select";
import { BANKS_URL } from "../ApplicationVariables";

const banksDummy = [
    { label: 'Bank1', value: 'Bank1_id' },
    { label: 'Bank2', value: 'Bank2_id' },
    { label: 'Bank3', value: 'Bank3_id' }
]

const BanksDropDown = (props) => {

    const [banks, setBanks] = useState([]);
    const [error, setError] = useState(null);

    let urlBanksInCountry = BANKS_URL + '/' + props.countryCode;

    const selectBankRef = useRef();

    const fetchBanksHandler = useCallback(async () => {

        if (selectBankRef.current) {
            selectBankRef.current.clearValue();
        }

        setError(null);
        try {

            const response = await fetch(urlBanksInCountry);

            if (!response.ok) {
                throw new Error('Something went wrong! Data could not be fetched!');
            }

            const dataInText = await response.text();

            if (dataInText.length === 0) {
                throw new Error('No banks for selected country!');
            }

            const data = JSON.parse(dataInText);
            console.log(data);

            const transfromedBanks = data.map(bank => {
                return {
                    label: bank.name,
                    value: bank.id
                };
            });

            setBanks(transfromedBanks);

        } catch (error) {
            console.log(error.message);
            setError(error.message);
        }


    }, [props.countryCode]);

    useEffect(() => {
        fetchBanksHandler()
    }, [fetchBanksHandler]);


    const bankChangeHandler = (selectedBank) => {
        props.onSelectBank(selectedBank);
    }


    return (
        <div style={{ maxWidth: '400px' }}>
            {!error && <Fragment>
                <p>Select Bank...</p>
                <Select ref={selectBankRef} options={banks} onChange={bankChangeHandler} />
            </Fragment>}
            {error && <Fragment>
                <p>Select Bank...</p>
                <span style={{ color: 'red', fontSize: 12 }}>{error} Showing static list.</span>
                <Select options={banksDummy} onChange={bankChangeHandler} />
            </Fragment>}
        </div>
    )
}

export default BanksDropDown;
