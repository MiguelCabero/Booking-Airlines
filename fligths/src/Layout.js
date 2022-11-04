import { React, useContext } from 'react';
import Navigation from './Components/Navigation/Navigation';
import AppContext from './store/app-context';

const Layout = (props) => {
	const currentAppContext = useContext(AppContext);
	return (
		<div>
			<Navigation />
			{props.children}
		</div>
	);
};

export default Layout;
