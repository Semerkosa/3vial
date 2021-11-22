const SourceTypesDropDown = (props) => {
    const sourceChangeHandler = event => {
        props.onSelectSourceType(event.target.value);
    };
    return (
        <div>
            <select onChange={sourceChangeHandler} data-testid="source-type-select">
                <option value="">--Select source type--</option>
                <option value="Bank">Bank</option>
                <option value="Crypto">Crypto</option>
                <option value="Stock">Stock</option>
            </select>
        </div>
    );
};

export default SourceTypesDropDown;