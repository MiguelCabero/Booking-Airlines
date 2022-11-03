import ToggleCheck from '../ToggleCheck';
import './Filters.component.css';

function Filters(props) {
	console.log(props.dates);
	return (
		<div className='results-filters'>
			<form className='filters-form'>
				<h3>Filters:</h3>
				<label htmlFor='Company-filter'>Airline: </label>
				<select
					name='Company-filter'
					id='company-filter'>
					{props.airlines &&
						props.airlines.map((airline, index) => (
							<option
								value={airline.id}
								key={index}>
								{airline.name}
							</option>
						))}
				</select>
				<label htmlFor='Date-filter'>Date: </label>
				<select
					name='Date-filter'
					id='date-filter'>
					{props.dates &&
						props.dates.map((date, index) => (
							<option
								value={date}
								key={index}>
								{date}
							</option>
						))}
				</select>
				<ToggleCheck
					label='Layover'
					action='Layover'
				/>
				<ToggleCheck
					label='Luggage'
					action='Luggage'
				/>
			</form>
		</div>
	);
}

export default Filters;
