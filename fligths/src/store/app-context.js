import { createContext, useState } from 'react';

let initialAppContext = JSON.parse(
	window.localStorage.getItem('app-context')
) || {
	step: 1,
	searched: false,
	booked: false,
	setStep: (step) => {},
};

const AppContext = createContext(initialAppContext);

export function AppContextProvider(props) {
	const [currentStep, setCurrentStep] = useState(initialAppContext.step);

	function setStepHandler(step) {
		setCurrentStep(step);
	}

	const context = {
		step: currentStep,
		searched: currentStep >= 3,
		booked: currentStep >= 5,
		setStep: setStepHandler,
	};
	window.localStorage.setItem('app-context', JSON.stringify(context));
	return (
		<AppContext.Provider value={context}>{props.children}</AppContext.Provider>
	);
}

export default AppContext;
