import ToggleCheck from '../ToggleCheck';
import './DatesForm.component.css';
import InputDate from './InputDate';
import TripField from './TripField';
function DatesForm(props) {
	return (
		<div className='form-container'>
			<h2>Select dates</h2>
			<form className='booking-form'>
				<div className='inputs-field'>
					<TripField
						origin={props.origin}
						destination={props.destination}
					/>
					<InputDate
						message='Select trip date'
						action='trip-date'
					/>

					<InputDate
						message='Select back date'
						action='back-date'
					/>

					<ToggleCheck
						label='Roundtrip'
						action='roundtrip'
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
