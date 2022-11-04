import { createContext, useState } from 'react';

let initialTripContext = JSON.parse(
	window.localStorage.getItem('trip-context')
) || {
	availableCities: [],
	trips: [
		{
			selectedOrigin: {},
			selectedDestination: {},
			selectedDate: new Date().toISOString().split('T')[0],
			luggage: '',
			layover: '',
			results: [],
			selectedCompany: '',
			basePrice: 0,
			finalPrices: [],
		},
		{
			selectedOrigin: {},
			selectedDestination: {},
			selectedDate: new Date().toISOString().split('T')[0],
			luggage: '',
			layover: '',
			results: [],
			selectedCompany: '',
			basePrice: 0,
			finalPrices: [],
		},
	],
	setAvailableCities: (cities) => {},
	setTrips: (trips) => {},
};

const TripContext = createContext(initialTripContext);

export function TripContextProvider(props) {
	const [currentAvailableCities, setCurrentAvailableCities] = useState(
		initialTripContext.availableCities
	);

	const [currentTrips, setCurrentTrips] = useState(initialTripContext.trips);

	function setCitiesHandler(cities) {
		setCurrentAvailableCities(cities);
	}

	function tripsHandler(trips) {
		setCurrentTrips(trips);
	}

	const context = {
		availableCities: currentAvailableCities,
		trips: currentTrips,
		setAvailableCities: setCitiesHandler,
		setTrips: tripsHandler,
	};

	window.localStorage.setItem('trip-context', JSON.stringify(context));
	return (
		<TripContext.Provider value={context}>
			{props.children}
		</TripContext.Provider>
	);
}

export default TripContext;
