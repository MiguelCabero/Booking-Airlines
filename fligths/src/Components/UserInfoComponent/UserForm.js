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
	function handleClick(event) {
		event.preventDefault();
		users.push(structuredClone(passengerBase));
		console.log(currentPassengersContext.passengers);
		currentPassengersContext.setPassengers([...users]);
	}

	/*function handleUpdate(event) {
			event.preventDefault();
			users.splice(event.target.value, 1);
			currentPassengersContext.setPassengers([...users]);
		}*/

	return (
		<div className='passenger-form-container'>
			<h2>Insert passengers information</h2>
			<form
				className='passenger-form'
				onSubmit={clickHandler}>
				{currentPassengersContext.passengers.map((passenger, index) => (
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
