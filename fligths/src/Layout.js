import { React, useContext } from 'react';
import PreviousSection from './Components/PreviousSectionComponent/PreviousSection';
import AppContext from './store/app-context';

const Layout = (props) => {
	const currentAppContext = useContext(AppContext);
	return (
		<div>
			{props.children}
			{currentAppContext.step != 1 && <PreviousSection />}
		</div>
	);
};

export default Layout;
