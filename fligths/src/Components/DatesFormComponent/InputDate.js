import './InputDate.component.css';
import { React, useContext } from 'react';
import TripContext from '../../store/trip-context';
function InputDate(props) {
	const tripContext = useContext(TripContext);

	function handleChange(event) {
		event.preventDefault();
		if (props.action == 'trip-date') {
			tripContext.trip.setDate(event.target.value);
		} else {
			tripContext.setBackTrip({
				selectedOrigin: tripContext.trip.selectedDestination,
				selectedDestination: tripContext.trip.selectedOrigin,
				selectedDate: event.target.value,
			});
		}
	}
	return (
		<div className='input-date'>
			<div>
				<label htmlFor={props.action}>{props.message}</label>
				<input
					type='date'
					name={props.action}
					id={props.action}
					onChange={handleChange}
					ref={props.reference}
				/>
			</div>

			<span className='errorSpan invisible'>{props.errorMessage}</span>
		</div>
	);
}

export default InputDate;
