import ToggleCheck from "../ToggleCheck";
import "./Filters.component.css";

function Filters(props) {
  let set = new Set(props.airlines.map((obj) => obj.airlineName));
  set = Array.from(set);
  
  return (
    <div className="results-filters">
      <form className="filters-form">
        <h3>Filters:</h3>
        <label htmlFor="Company-filter">Airline: </label>
        <select name="Company-filter" id="company-filter">
			<option value={null}>
			-- Select airline --
			</option>
          {props.airlines &&
            set.map((airline, index) => (
              <option value={airline} key={index}>
                {airline}
              </option>
            ))}
        </select>
        <label htmlFor="Date-filter">Date: </label>
        <select name="Date-filter" id="date-filter">
		<option value={null}>
			-- Select date --
			</option>
          {props.dates &&
            props.dates.map((date, index) => (
              <option value={date.date_selected} key={index}>
                {date.date_selected}
              </option>
            ))}
        </select>
        <ToggleCheck label="Layover" action="Layover" />
        <ToggleCheck label="Luggage" action="Luggage" />
      </form>
    </div>
  );
}

export default Filters;
