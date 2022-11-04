import axios from 'axios';
import { React, useState, useEffect, useContext } from 'react';
import Country from './Country';
import './CountryList.component.css';
import AppContext from '../../store/app-context';
import TripContext from '../../store/trip-context';

function CountryList(props) {
	const tripContext = useContext(TripContext);
	useEffect(() => {
		if (tripContext.availableCities.length === 0) {
			callCities();
		}
	}, []);

	function callCities() {
		axios
			.get('http://localhost:8084/api/cities', {
				headers: {
					Accept: 'application/json',
				},
			})
			.then((response) => {
				tripContext.setAvailableCities(response.data);
			});
	}

	return (
		<div className='countryList'>
			<h2>Select your {props.action}</h2>

			{tripContext.availableCities
				.filter((city) => city.name != tripContext.trips[0].selectedOrigin.name)
				.map((city, index) => (
					<Country
						name={city.name}
						countryCode={city.country}
						key={index}
						action={props.action}
					/>
				))}
		</div>
	);
}

export default CountryList;
