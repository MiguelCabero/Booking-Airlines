import axios from "axios";
import { React, useState, useEffect, useContext } from "react";
import Country from "./Country";
import "./CountryList.component.css";
import AppContext from "../../store/app-context";
import TripContext from "../../store/trip-context";

function CountryList(props) {
  const tripContext = useContext(TripContext);
  //   console.log(tripContext);
  useEffect(() => {
    if (tripContext.trip.availableCountries.length === 0) {
      callCities();
    }
  }, []);

  function callCities() {
    axios
      .get("http://localhost:8084/api/cities", {
        headers: {
          Accept: "application/json",
        },
      })
      .then((response) => {
        tripContext.trip.setCities(response.data);
      });
  }

  const currentAppContext = useContext(AppContext);

  function handlePrevious(event) {
    event.preventDefault();
    currentAppContext.setStep(--currentAppContext.step);

	if(currentAppContext.step == 1){
        window.localStorage.removeItem("trip-context")
		window.localStorage.removeItem("app-context")
		document. location. reload()
	}
  }
  return (
    <div className="countryList">
      <h2>Select your {props.action}</h2>

      {tripContext.trip.availableCountries
        .filter((city) => city.name != tripContext.trip.selectedOrigin.name)
        .map((city, index) => (
          <Country
            name={city.name}
            countryCode={city.country}
            key={index}
            action={props.action}
          />
        ))}
      {currentAppContext.step != 1 ? (
        <button onClick={handlePrevious}>Previous Section</button>
      ) : <></>}
    </div>
  );
}

export default CountryList;
