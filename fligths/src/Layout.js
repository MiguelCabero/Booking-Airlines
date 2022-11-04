import { React, useContext } from 'react';
import Navigation from './Components/Navigation/Navigation';
import PreviousSection from './Components/PreviousSectionComponent/PreviousSection';
import AppContext from './store/app-context';

const Layout = (props) => {
	const currentAppContext = useContext(AppContext);
	return (
		<div>
			<Navigation />
			{props.children}
			{currentAppContext.step != 1 && <PreviousSection />}
		</div>
	);
};

export default Layout;
