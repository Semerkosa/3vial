const Button = (props) => {
    return (
        <button className="button-primary" type={props.type} onClick={props.onClick}>{props.children}</button>
    )
}
export default Button