import Filters from './Filters';
import ResultItem from './ResultItem';
import './ResultsForm.component.css';
import { React, useContext, useEffect, useState } from 'react';
import AppContext from '../../store/app-context';
import TripContext from '../../store/trip-context';
import axios from 'axios';

function ResultsForm(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);

	let filters = currentTripContext.trip.results;

	console.log(currentTripContext.trip.results);

	useEffect(() => {
		if (
			currentTripContext.trip.selectedOrigin != null &&
			currentTripContext.trip.selectedDestination != null
		) {
			callResults();
		}
	}, []);

	function callResults() {
		axios
			.get(
				`http://localhost:8083/api/prices/${currentTripContext.trip.selectedOrigin.id}/${currentTripContext.trip.selectedDestination.id}/${currentTripContext.trip.selectedDate}`,
				{
					headers: {
						Accept: 'application/json',
					},
				}
			)
			.then((response) => {
				currentTripContext.trip.setResults(response.data);
			});
	}

	function clickHandler(event) {
		event.preventDefault();
		currentAppContext.setStep(++currentAppContext.step);
	}

	return (
		<div className='results-container'>
			<h2>Choose a flight</h2>
			<Filters
				airlines={filters}
				dates={filters}
			/>
			{props.results &&
				props.results.map((result, index) => (
					<ResultItem
						onSubmit={clickHandler}
						companyName={result.companyName.name}
						flightNumber={result.flightNumber}
						date={result.date}
						time={result.time}
						duration={result.duration}
						layover={result.layover}
						lugagge={result.lugagge}
						price={result.price}
						key={index}
						index={index}
					/>
				))}
		</div>
	);
}

export default ResultsForm;
