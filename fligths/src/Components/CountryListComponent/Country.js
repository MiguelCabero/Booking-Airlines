import './Country.component.css';
import { React, useContext } from 'react';
import AppContext from '../../store/app-context';
import TripContext from '../../store/trip-context';
function Country(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);
	const baseTrip = {
		selectedOrigin: {},
		selectedDestination: {},
		selectedDate: new Date().toISOString().split('T')[0],
		luggage: '',
		layover: '',
		results: [],
		selectedCompany: '',
		basePrice: 0,
		finalPrices: [],
	};

	let trips = [...currentTripContext.trips];

	function clickHandler() {
		let selected = currentTripContext.availableCities.find(
			(city) => city.name == props.name
		);
		props.action == 'origin'
			? (trips[0].selectedOrigin = selected)
			: (trips[0].selectedDestination = selected);

		currentTripContext.setTrips(trips);
		currentAppContext.setStep(++currentAppContext.step);
	}
	function getFlagEmoji(countryCode) {
		const codePoints = countryCode
			.toUpperCase()
			.split('')
			.map((char) => 127397 + char.charCodeAt());
		return String.fromCodePoint(...codePoints);
	}
	return (
		<>
			<div className='countryContainer'>
				<button
					className='country'
					onClick={clickHandler}>
					{props.name} {getFlagEmoji(props.countryCode)}
				</button>
			</div>
		</>
	);
}

export default Country;
