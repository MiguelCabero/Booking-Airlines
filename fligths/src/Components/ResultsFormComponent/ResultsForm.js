import Filters from './Filters';
import ResultItem from './ResultItem';
import './ResultsForm.component.css';
import { React, useContext, useEffect, useRef, useState } from 'react';
import AppContext from '../../store/app-context';
import TripContext from '../../store/trip-context';
import axios from 'axios';

function ResultsForm(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);
	const dateFilter = useRef(null);
	const companyFilter = useRef(null);
	const lugaggeFilter = useRef(null);
	const layoverFilter = useRef(null);

	let filters = currentTripContext.trip.results;
	console.log(filters);

	const [filteredResults, setFilteredResults] = useState([
		...currentTripContext.trip.results,
	]);

	function filterHandler() {
		let filtersApplied = [...currentTripContext.trip.results];
		if (dateFilter.current.value != '') {
			filtersApplied = filtersApplied.filter(
				(result) => result.date_selected == dateFilter.current.value
			);
		}
		if (companyFilter.current.value != '') {
			filtersApplied = filtersApplied.filter(
				(result) => result.airlineName == companyFilter.current.value
			);
		}
		if (lugaggeFilter.current.checked == true) {
			filtersApplied = filtersApplied.filter((result) => result.lugagge != 0);
		}
		if (layoverFilter.current.checked == true) {
			filtersApplied = filtersApplied.filter((result) => result.layover != 0);
		}
		console.log(layoverFilter);
		setFilteredResults(filtersApplied);
	}

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

	function randomTime() {
		let hrs = Math.round(Math.random() * 24);
		let mins = Math.round(Math.random() * 60);
		let hFormat = hrs < 10 ? '0' : '';
		let mFormat = mins < 10 ? '0' : '';

		return String(hFormat + hrs + ':' + mFormat + mins);
	}

	return (
		<div className='results-container'>
			<h2>Choose a flight</h2>
			<Filters
				airlines={filters}
				dates={filters}
				action={filterHandler}
				dateFilterReference={dateFilter}
				companyFilterReference={companyFilter}
				lugaggeFilterReference={lugaggeFilter}
				layoverFilterReference={layoverFilter}
			/>
			{currentTripContext.trip.results &&
				(filteredResults.length > 0 ? (
					filteredResults.map((result, index) => (
						<ResultItem
							onSubmit={clickHandler}
							companyName={result.airlineName}
							flightNumber={Math.random().toString(36).slice(2)}
							date={result.date_selected}
							time={randomTime()}
							duration={`${result.duration} h`}
							layover={result.layover}
							lugagge={result.lugagge}
							layoverText={result.layover == 0 ? 'No' : 'Yes'}
							lugaggeText={result.lugagge == 0 ? 'No' : 'Yes'}
							price={result.price}
							key={index}
							index={index}
						/>
					))
				) : (
					<p className='notFoundFlights'>
						There is no flights with those specification for that date
					</p>
				))}
		</div>
	);
}

export default ResultsForm;
