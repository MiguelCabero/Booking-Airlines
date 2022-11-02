import Filters from './Filters';
import ResultItem from './ResultItem';
import './ResultsForm.component.css';

function ResultsForm(props) {
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
