import AppContext from '../../store/app-context';
import { React, useContext } from 'react';
import TripContext from '../../store/trip-context';
import styles from './PreviousSection.component.css';

const PreviousSection = () => {
	const currentAppContext = useContext(AppContext);
	const tripContext = useContext(TripContext);

	function handlePrevious(event) {
		event.preventDefault();
		currentAppContext.setStep(--currentAppContext.step);

		if (currentAppContext.step == 1) {
			tripContext.trip.setOrigin({});
		}
	}

	return (
		<div className='buttonContainer'>
			<button
				className='button'
				onClick={handlePrevious}>
				Previous step
			</button>
		</div>
	);
};

export default PreviousSection;
