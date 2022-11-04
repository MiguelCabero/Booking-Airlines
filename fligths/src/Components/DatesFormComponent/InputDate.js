import './InputDate.component.css';
import { React, useContext } from 'react';
import TripContext from '../../store/trip-context';
function InputDate(props) {
	const tripContext = useContext(TripContext);

	let currentTrips = [...tripContext.trips];

	function handleChange(event) {
		event.preventDefault();
		if (props.validationHandler(event)) {
			if (props.action == 'trip-date') {
				currentTrips[0].selectedDate = event.target.value;
			} else {
				currentTrips[1].selectedOrigin = currentTrips[0].selectedOrigin;
				currentTrips[1].selectedDestination =
					currentTrips[0].selectedDestination;
				currentTrips[1].selectedDate = event.target.value;
			}

			tripContext.setTrips([...currentTrips]);
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
