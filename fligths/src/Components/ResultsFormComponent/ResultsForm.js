import Filters from './Filters';
import ResultItem from './ResultItem';
import './ResultsForm.component.css';
import { React, useContext } from 'react';
import AppContext from '../../store/app-context';
import TripContext from '../../store/trip-context';

function ResultsForm(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);
	function clickHandler(event) {
		event.preventDefault();
		currentAppContext.setStep(++currentAppContext.step);
	}

	console.log(currentTripContext);
	let airlines = [];
	let dates = [];

	props.results.map((result) => dates.push(result.date));
	props.results.map((result) => airlines.push(result.companyName));

	return (
		<div className='results-container'>
			<h2>Choose a flight</h2>
			<Filters
				airlines={airlines}
				dates={dates}
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
