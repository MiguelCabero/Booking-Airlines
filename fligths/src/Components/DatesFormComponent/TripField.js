import './TripField.component.css';
function TripField(props) {
	return (
		<div className='trip-inputs'>
			<div className='input-text'>
				<label htmlFor='trip-origin'>Origin</label>
				<input
					type='text'
					name='trip-origin'
					id='trip-origin'
					defaultValue={props.origin}
					readOnly
				/>
			</div>
			<div className='input-text'>
				<label htmlFor='trip-destination'>Destination</label>
				<input
					type='text'
					name='trip-destination'
					id='trip-destination'
					defaultValue={props.destination}
					readOnly
				/>
			</div>
		</div>
	);
}

export default TripField;
