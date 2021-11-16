import Select from "react-select";
import { NORDIGEN_COUNTRIES_URL } from "../ApplicationVariables";
import { Fragment, useCallback, useEffect, useState } from "react";


const countriesDummy = [
    { label: 'Country1', value: 'Country1_id' },
    { label: 'Country2', value: 'Country2_id' },
    { label: 'Country3', value: 'Country3_id' }
]


const CountriesDropDown = (props) => {

    const [countries, setCountries] = useState([]);
    const [error, setError] = useState(null);

    const fetchCountriesHandler = useCallback(async () => {

        setError(null);

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
                    label: country.countryName,
                    value: country.countryCode
                };
            });

            setCountries(transformedCountries);

        } catch (error) {
            console.log(error.message);
            setError(error.message);
        }

    }, []);

    useEffect(() => {
        fetchCountriesHandler()
    }, [fetchCountriesHandler]);


    const countryChangeHandler = (selectedOption) => {
        props.onSelectCountry(selectedOption.value);
    }

    return (
        <div style={{ width: '200px' }}>
            {!error &&
                <Fragment>
                    <p>Select country...</p>
                    <Select options={countries} onChange={countryChangeHandler} />
                </Fragment>
            }
            {/* Temporary code showing static list since endpoints on the backend are not completed. */}
            {error &&
                <Fragment>
                    <p>Select country...</p>
                    <span style={{ color: 'red', fontSize: 12 }}>{error} Showing static list</span>
                    <Select options={countriesDummy} onChange={countryChangeHandler} />
                </Fragment>
            }
        </div>
    )
}

export default CountriesDropDown;