import { React, useContext } from 'react';
import { Link } from 'react-router-dom';
import './Navigation.component.css';
import AppContext from '../../store/app-context';
const Navigation = () => {
	const currentAppContext = useContext(AppContext);

	function logout() {
		currentAppContext.setAutenticated(false);
		window.location.href = '/';
	}
	return (
		<header className='header'>
			<div className='logo-container'>
				<h3>Solera Flights</h3>
			</div>

			<nav className='links-container'>
				<ul>
					<li>
						<Link to={'/'}>Book</Link>
					</li>
					<li>
						<Link to={'/about'}>Information</Link>
					</li>
					{!currentAppContext.autenticated && (
						<li>
							<Link to={'/login'}>Login</Link>
						</li>
					)}
					{currentAppContext.autenticated && (
						<li>
							<Link to={'/administration'}>Admin Panel</Link>
						</li>
					)}
					{currentAppContext.autenticated && (
						<button
							onClick={logout}
							className='navButton'>
							Log out
						</button>
					)}
				</ul>
			</nav>
		</header>
	);
};

export default Navigation;
