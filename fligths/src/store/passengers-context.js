import { createContext, useState } from 'react';

let initialPassengersContext = JSON.parse(
	window.localStorage.getItem('passengers')
) || {
	passengers: [
		{
			name: '',
			surname: '',
			nationality: '',
			identification: '',
			age: 2,
			bags: 0,
		},
	],
	setPassengers: (passengers) => {},
};

const PassengersContext = createContext(initialPassengersContext);

export function PassengersContextProvider(props) {
	const [currentPassengers, setCurrentPassengers] = useState(
		initialPassengersContext.passengers
	);

	function handlePassengers(passengers) {
		setCurrentPassengers((prevState) => {
			prevState = passengers;
			return prevState;
		});
	}

	const context = {
		passengers: currentPassengers,
		setPassengers: handlePassengers,
	};
	window.localStorage.setItem('passengers', JSON.stringify(context));

	return (
		<PassengersContext.Provider value={context}>
			{props.children}
		</PassengersContext.Provider>
	);
}

export default PassengersContext;
