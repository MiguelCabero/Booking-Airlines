import './UserForm.component.css';
import UserInputs from './UserInputs';
import { React, useState, useContext } from 'react';
import AppContext from '../../store/app-context';
import TripContext from '../../store/trip-context';

function UserForm(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);

	function clickHandler(event) {
		event.preventDefault();
		currentAppContext.setStep(++currentAppContext.step);
	}
	const [passengers, setPassengers] = useState(1);
	let users = [];
	let price = 80;
	function handleClick(event) {
		event.preventDefault();
		setPassengers(passengers + 1);
	}

	for (let i = 0; i < passengers; i++) {
		users.push(
			<UserInputs
				key={i}
				index={i}
			/>
		);
	}
	return (
		<div className='passenger-form-container'>
			<h2>Insert passengers information</h2>
			<form
				className='passenger-form'
				onSubmit={clickHandler}>
				{users}
				<div className='passenger-submit-field'>
					<div className='add-passenger-container'>
						<button
							className='add-passenger-button'
							onClick={handleClick}>
							+ Add Passenger
						</button>
					</div>
					<div>
						<p>
							<b>Total price: {currentTripContext.trip.price}€</b>
						</p>
					</div>
					<input
						type='submit'
						defaultValue='Book'
						className='submit-book'
					/>
				</div>
			</form>
		</div>
	);
}

export default UserForm;
