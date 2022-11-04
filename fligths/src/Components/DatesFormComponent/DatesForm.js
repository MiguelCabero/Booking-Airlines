import ToggleCheck from '../ToggleCheck';
import './DatesForm.component.css';
import InputDate from './InputDate';
import TripField from './TripField';
import TripContext from '../../store/trip-context';
import AppContext from '../../store/app-context';
import { React, useContext, useState, useRef } from 'react';

function DatesForm(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);
	const inputTrip = useRef(null);
	const inputBacktrip = useRef(null);
	let currentTrips = [...currentTripContext.trips];

	const [checked, setChecked] = useState(props.checked);
	function handleToggle() {
		setChecked(!checked);
	}

	function validateForm(event) {
		event.preventDefault();
		let today = new Date();
		let yesterday = new Date();
		yesterday.setDate(today.getDate() - 1);
		let valid = false;
		if (
			inputTrip.current.value == '' ||
			Date.parse(inputTrip.current.value) < Date.parse(yesterday)
		) {
			document
				.getElementsByClassName('errorSpan')[0]
				.classList.remove('invisible');
			valid = false;
		} else {
			document
				.getElementsByClassName('errorSpan')[0]
				.classList.add('invisible');
			valid = true;
		}

		if (
			checked &&
			(inputBacktrip.current.value == '' ||
				inputBacktrip.current.value < inputTrip.current.value)
		) {
			document
				.getElementsByClassName('errorSpan')[1]
				.classList.remove('invisible');
			valid = false;
		} else {
			checked &&
				document
					.getElementsByClassName('errorSpan')[1]
					.classList.add('invisible');

			valid = true;
		}

		return valid;
	}
	function submitHandler(event) {
		validateForm(event);
		if (!checked) {
			currentTrips.splice(1, 1);
			currentTripContext.setTrips([...currentTrips]);
		}
		currentAppContext.setStep(++currentAppContext.step);
	}

	return (
		<div className='form-container'>
			<h2>Select dates</h2>
			<form
				className='booking-form'
				onSubmit={submitHandler}>
				<div className='inputs-field'>
					<TripField
						origin={props.origin}
						destination={props.destination}
					/>
					<InputDate
						message='Select trip date'
						action='trip-date'
						reference={inputTrip}
						errorMessage='La fecha no puede ser nula ni anterior a la actual'
						validationHandler={validateForm}
					/>

					{checked && (
						<InputDate
							message='Select back date'
							action='back-date'
							reference={inputBacktrip}
							errorMessage='La fecha no puede ser nula ni anterior a la fecha de ida'
							validationHandler={validateForm}
						/>
					)}

					<ToggleCheck
						label='Roundtrip'
						action='roundtrip'
						checked={checked}
						onChange={handleToggle}
					/>
				</div>
				<div className='submit-field'>
					<input
						type='submit'
						defaultValue='Search'
					/>
				</div>
			</form>
		</div>
	);
}

export default DatesForm;
