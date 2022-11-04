import Filters from './Filters';
import ResultItem from './ResultItem';
import './ResultsForm.component.css';
import { React, useContext, useEffect, useRef, useState } from 'react';
import TripContext from '../../store/trip-context';
import axios from 'axios';

function ResultsForm(props) {
	const currentTripContext = useContext(TripContext);
	const dateFilter = useRef(null);
	const companyFilter = useRef(null);
	const lugaggeFilter = useRef(null);
	const layoverFilter = useRef(null);

	let currentTrips = [...currentTripContext.trips];

	let filters = currentTripContext.trips[0].results;

	const [filteredResults, setFilteredResults] = useState([
		...currentTripContext.trips[0].results,
	]);

	function callResults() {
		axios
			.get(
				`http://localhost:8083/api/prices/${currentTripContext.trips[0].selectedOrigin.id}/${currentTripContext.trips[0].selectedDestination.id}/${currentTripContext.trips[0].selectedDate}`,
				{
					headers: {
						Accept: 'application/json',
					},
				}
			)
			.then((response) => {
				currentTrips[0].results = response.data;
				currentTripContext.setTrips(currentTrips);
			});
	}

	useEffect(() => {
		if (
			currentTripContext.trips[0].selectedOrigin != null &&
			currentTripContext.trips[0].selectedDestination != null
		) {
			callResults();
			setFilteredResults([...currentTripContext.trips[0].results]);
		}
	}, []);

	function filterHandler() {
		let filtersApplied = [...currentTripContext.trips[0].results];
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
			filtersApplied = filtersApplied.filter((result) => result.luggage != 0);
		}
		if (layoverFilter.current.checked == true) {
			filtersApplied = filtersApplied.filter((result) => result.layover != 0);
		}
		setFilteredResults(filtersApplied);
	}

	//Para que la info de los resultados cambie sin necesidad de recargar la página
	useEffect(() => {
		if (
			currentTripContext.trips[0].selectedOrigin != null &&
			currentTripContext.trips[0].selectedDestination != null
		) {
			setFilteredResults([...currentTripContext.trips[0].results]);
		}
	}, [currentTripContext.trips]);

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
			{currentTripContext.trips[0].results &&
				(filteredResults.length > 0 ? (
					filteredResults.map((result, index) => (
						<ResultItem
							companyId={result.airline}
							companyName={result.airlineName}
							flightNumber={Math.random().toString(36).slice(2)}
							date={result.date_selected}
							time={randomTime()}
							duration={`${result.duration} h`}
							layover={result.layover}
							luggage={result.luggage}
							layoverText={result.layover == 0 ? 'No' : 'Yes'}
							luggageText={result.luggage == 0 ? 'No' : 'Yes'}
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
