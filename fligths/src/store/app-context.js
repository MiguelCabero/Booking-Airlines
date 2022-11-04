import { createContext, useState } from 'react';

let initialAppContext = JSON.parse(
	window.localStorage.getItem('app-context')
) || {
	step: 1,
	searched: false,
	booked: false,
	autenticated: false,
	setStep: (step) => {},
};

const AppContext = createContext(initialAppContext);

export function AppContextProvider(props) {
	const [currentStep, setCurrentStep] = useState(initialAppContext.step);
	const [currentAutenticated, setAutenticated] = useState(
		initialAppContext.autenticated
	);

	function setStepHandler(step) {
		setCurrentStep(step);
	}

	function handleAuth(auth) {
		setAutenticated(auth);
	}

	const context = {
		step: currentStep,
		searched: currentStep >= 3,
		booked: currentStep >= 5,
		autenticated: currentAutenticated,
		setStep: setStepHandler,
		setAutenticated: handleAuth,
	};
	window.localStorage.setItem('app-context', JSON.stringify(context));
	return (
		<AppContext.Provider value={context}>{props.children}</AppContext.Provider>
	);
}

export default AppContext;
