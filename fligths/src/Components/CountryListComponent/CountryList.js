import axios from "axios";
import { React, useState, useEffect } from "react";
import Country from "./Country";
import "./CountryList.component.css";

function CountryList(props) {
  const [cities, setCities] = useState([]);

  useEffect(() => {
    callCities();
  });

  function callCities() {
    axios
      .get("http://localhost:8084/api/cities", {
        headers: {
          Accept: "application/json",
        },
      })
      .then((response) => {
        setCities(response.data, []);
      });
  }

  return (
    <div className="countryList">
      <h2>Select your {props.action}</h2>

      {cities.map((city) => (
        <Country name={city.name} countryCode={city.country} />
      ))}
      {/* <Country
				name='Madrid'
				countryCode='ES'
			/>
			<Country
				name='Seville'
				countryCode='ES'
			/>
			<Country
				name='Barcelona'
				countryCode='ES'
			/>
			<Country
				name='London'
				countryCode='GB'
			/> */}
    </div>
  );
}

export default CountryList;
