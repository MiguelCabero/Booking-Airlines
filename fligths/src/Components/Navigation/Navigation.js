import { React } from 'react';
import { Link } from 'react-router-dom';
import './Navigation.component.css';
const Navigation = () => {
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
				</ul>
			</nav>
		</header>
	);
};

export default Navigation;
