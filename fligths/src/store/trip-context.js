import { createContext, useState } from 'react';

const TripContext = createContext([
	{
		availableCountries: [],
		selectedOrigin: {},
		selectedDestination: {},
		selectedDate: '',
		setOrigin: (origin) => {},
		setDestination: (destination) => {},
		setDate: (date) => {},
		setCities: (date) => {},
	},
]);

export function TripContextProvider(props) {
	const [currentAvailableCities, setCurrentAvailableCities] = useState([]);
	const [currentOrigin, setCurrentOrigin] = useState({});
	const [currentDestination, setCurrentDestination] = useState({});
	const [currentSelectedDate, setCurrentSelectedDate] = useState(
		new Date().toISOString().split('T')[0]
	);

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
		availableCountries: currentAvailableCities,
		selectedOrigin: currentOrigin,
		selectedDestination: currentDestination,
		selectedDate: currentSelectedDate,
		setOrigin: setOriginHandler,
		setDestination: setDestinationHandler,
		setDate: setCurrentDateHandler,
		setCities: setCitiesHandler,
	};
	return (
		<TripContext.Provider value={context}>
			{props.children}
		</TripContext.Provider>
	);
}

export default TripContext;
