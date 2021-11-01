import { useState, useEffect } from "react";

const CurrencyDropDown = (props) => {

    const [currency, setCurrency] = useState('BGN');

    useEffect(() => {
        props.onSelectCurrency(currency);
      }, []);


    const currencyChangeHandler = event => {
        setCurrency(event.target.value)
        props.onSelectCurrency(event.target.value);


    }

    return (
        <div>
            <select onChange={currencyChangeHandler}>
                <option value="BGN">BGN</option>
                <option value="GBP">GBP</option>
            </select>
        </div>
    )
}

export default CurrencyDropDown;