import { createContext, useState } from 'react';

let initialTripContext = JSON.parse(
	window.localStorage.getItem('trip-context')
) || {
	trip: {
		availableCountries: [],
		selectedOrigin: {},
		selectedDestination: {},
		selectedDate: new Date().toISOString().split('T')[0],
		setOrigin: (origin) => {},
		setDestination: (destination) => {},
		setDate: (date) => {},
		setCities: (date) => {},
	},
	backTrip: {
		selectedOrigin: {},
		selectedDestination: {},
		selectedDate: '',
	},
	setBackTrip: (backTrip) => {},
};

const TripContext = createContext(initialTripContext);

export function TripContextProvider(props) {
	const [currentAvailableCities, setCurrentAvailableCities] = useState(
		initialTripContext.trip.availableCountries
	);
	const [currentOrigin, setCurrentOrigin] = useState(
		initialTripContext.trip.selectedOrigin
	);
	const [currentDestination, setCurrentDestination] = useState(
		initialTripContext.trip.selectedDestination
	);
	const [currentSelectedDate, setCurrentSelectedDate] = useState(
		initialTripContext.trip.selectedDate
	);
	const [currentBackTrip, setCurrentBackTrip] = useState(
		initialTripContext.backTrip
	);

	function backTripHandler(backTrip) {
		setCurrentBackTrip(backTrip);
	}

	function setOriginHandler(origin) {
		setCurrentOrigin(origin);
	}

	function setCitiesHandler(cities) {
		setCurrentAvailableCities(cities);
	}

	function setDestinationHandler(destination) {
		setCurrentDestination(destination);
	}

	function setCurrentDateHandler(date) {
		setCurrentSelectedDate(date);
	}

	const context = {
		trip: {
			availableCountries: currentAvailableCities,
			selectedOrigin: currentOrigin,
			selectedDestination: currentDestination,
			selectedDate: currentSelectedDate,
			setOrigin: setOriginHandler,
			setDestination: setDestinationHandler,
			setDate: setCurrentDateHandler,
			setCities: setCitiesHandler,
		},
		backTrip: currentBackTrip,
		setBackTrip: backTripHandler,
	};

	window.localStorage.setItem('trip-context', JSON.stringify(context));
	return (
		<TripContext.Provider value={context}>
			{props.children}
		</TripContext.Provider>
	);
}

export default TripContext;
