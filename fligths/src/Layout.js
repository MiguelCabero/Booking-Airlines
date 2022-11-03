import { React, useContext } from 'react';
import AppContext from './store/app-context';
import TripContext from './store/trip-context';

const Layout = (props) => {
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
		<div>
			{props.children}
			{currentAppContext.step != 1 && (
				<button onClick={handlePrevious}>Previous Section</button>
			)}
		</div>
	);
};

export default Layout;
