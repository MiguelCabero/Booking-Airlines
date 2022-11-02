import './InputDate.component.css';
function InputDate(props) {
	return (
		<div className='input-date'>
			<label htmlFor={props.action}>{props.message}</label>
			<input
				type='date'
				name={props.action}
				id={props.action}
			/>
		</div>
	);
}

export default InputDate;
