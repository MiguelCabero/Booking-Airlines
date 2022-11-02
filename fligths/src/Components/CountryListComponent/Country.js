import './Country.component.css';
import { React, useContext } from 'react';
import AppContext from '../../store/app-context';
function Country(props) {
	const currentAppContext = useContext(AppContext);

	function clickHandler() {
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
		<div className='countryContainer'>
			<button
				className='country'
				onClick={clickHandler}>
				{props.name} {getFlagEmoji(props.countryCode)}
			</button>
		</div>
	);
}

export default Country;
