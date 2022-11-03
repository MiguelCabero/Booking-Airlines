import './Country.component.css';
import { React, useContext } from 'react';
import AppContext from '../../store/app-context';
import TripContext from '../../store/trip-context';
function Country(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);

	function clickHandler() {
		let selected = currentTripContext.trip.availableCountries.find(
			(city) => city.name == props.name
		);
		props.action == 'origin'
			? currentTripContext.trip.setOrigin(selected)
			: currentTripContext.trip.setDestination(selected);

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
