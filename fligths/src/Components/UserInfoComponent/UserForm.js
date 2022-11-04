import './UserForm.component.css';
import UserInputs from './UserInputs';
import { React, useState, useContext } from 'react';
import AppContext from '../../store/app-context';
import TripContext from '../../store/trip-context';
import PassengersContext from '../../store/passengers-context';

function UserForm(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);
	const currentPassengersContext = useContext(PassengersContext);
	let users = currentPassengersContext.passengers;
	let currentTrips = [...currentTripContext.trips]

	const passengerBase = {
		name: '',
		surname: '',
		nationality: '',
		identification: '',
		age: 2,
		bags: 0,
	};

	function clickHandler(event) {
		event.preventDefault();
		currentAppContext.setStep(++currentAppContext.step);
	}

	const handleClick = (event) => {
		event.preventDefault();
		users.push(structuredClone(passengerBase));
		console.log(currentPassengersContext.passengers);
		currentPassengersContext.setPassengers([...users]);
	};

	return (
		<div className='passenger-form-container'>
			<h2>Insert passengers information</h2>
			<form
				className='passenger-form'
				onSubmit={clickHandler}>
				{users.map((passenger, index) => (
					<UserInputs
						key={index}
						index={index}
						usersState={users}
					/>
				))}
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
							<b>Total price: {currentTrips[0].finalPrices.reduce((a,b)=> a+b)}€</b>
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
