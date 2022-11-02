import axios from 'axios';
import { React, useState, useEffect, useContext } from 'react';
import Country from './Country';
import './CountryList.component.css';
import TripContext from '../../store/trip-context';

function CountryList(props) {
	const tripContext = useContext(TripContext);

	useEffect(() => {
		if (tripContext.availableCountries.length === 0) {
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
				tripContext.setCities(response.data);
			});
	}

	return (
		<div className='countryList'>
			<h2>Select your {props.action}</h2>

			{tripContext.availableCountries
				.filter((city) => city != tripContext.selectedOrigin)
				.map((city, index) => (
					<Country
						name={city.name}
						countryCode={city.country}
						key={index}
						cityIndex={index}
					/>
				))}
		</div>
	);
}

export default CountryList;
