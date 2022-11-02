import CountryList from "./CountryListComponent/CountryList";
import DatesForm from "./DatesFormComponent/DatesForm";
import ResultsForm from "./ResultsFormComponent/ResultsForm";
import UserForm from "./UserInfoComponent/UserForm";
import { React, useContext } from "react";
import AppContext from "../store/app-context";
import TripContext from "../store/trip-context";
import PreviousSection from './PreviousSectionComponent/PreviousSection';

const Main = (props) => {
  const currentAppContext = useContext(AppContext);
  const tripContext = useContext(TripContext);
  return (
    <div>
      {currentAppContext.step == 1 && <CountryList action={"origin"} />}
      {currentAppContext.step == 2 && <CountryList action={"destination"} />}
      {currentAppContext.step == 3 && (
        <DatesForm
          origin={tripContext.trip.selectedOrigin.name}
          destination={tripContext.trip.selectedDestination.name}
          checked={true}
        />
      )}
      {currentAppContext.step == 4 && (
        <ResultsForm
          airlines={[
            { id: 1, name: "Iberia" },
            { id: 2, name: "Emirates" },
          ]}
          dates={[
            "11/11/2022",
            "12/11/2022",
            "13/11/2022",
            "14/11/2022",
            "15/11/2022",
          ]}
          results={[
            {
              companyName: {
                name: "Ryanair",
                id: 1,
              },
              flightNumber: 123,
              date: "11/11/2022",
              time: "12:00h",
              duration: "1h",
              layover: "No",
              lugagge: "No",
              price: "80€",
            },
            {
              companyName: {
                name: "Ryanair",
                id: 1,
              },
              flightNumber: 123,
              date: "11/11/2022",
              time: "12:00h",
              duration: "1h",
              layover: "No",
              lugagge: "No",
              price: "80€",
            },
          ]}
        />
		
      )}
      {currentAppContext.step == 5 && <UserForm />}
    </div>
  );
};

export default Main;
