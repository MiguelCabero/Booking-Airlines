import { createContext, useState } from 'react';

const AppContext = createContext({
	step: 1,
	searched: false,
	booked: false,
	setStep: (step) => {},
});

export function AppContextProvider(props) {
	const [currentStep, setCurrentStep] = useState(1);

	function setStepHandler(step) {
		setCurrentStep(step);
	}

	const context = {
		step: currentStep,
		searched: currentStep >= 3,
		booked: currentStep >= 5,
		setStep: setStepHandler,
	};
	return (
		<AppContext.Provider value={context}>{props.children}</AppContext.Provider>
	);
}

export default AppContext;
