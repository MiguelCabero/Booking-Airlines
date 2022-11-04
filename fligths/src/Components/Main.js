import CountryList from './CountryListComponent/CountryList';
import DatesForm from './DatesFormComponent/DatesForm';
import ResultsForm from './ResultsFormComponent/ResultsForm';
import UserForm from './UserInfoComponent/UserForm';
import { React, useContext } from 'react';
import AppContext from '../store/app-context';
import TripContext from '../store/trip-context';
import PreviousSection from './PreviousSectionComponent/PreviousSection';
import Payment from './PaymentComponent/Payment';

const Main = () => {
	const currentAppContext = useContext(AppContext);
	const tripContext = useContext(TripContext);
	return (
		<div>
			{currentAppContext.step == 1 && <CountryList action={'origin'} />}
			{currentAppContext.step == 2 && <CountryList action={'destination'} />}
			{currentAppContext.step == 3 && (
				<DatesForm
					origin={tripContext.trips[0].selectedOrigin.name}
					destination={tripContext.trips[0].selectedDestination.name}
					checked={true}
				/>
			)}
			{currentAppContext.step == 4 && <ResultsForm />}
			{currentAppContext.step == 5 && <UserForm />}
			{currentAppContext.step == 6 && <Payment />}
			{currentAppContext.step != 1 && <PreviousSection />}

		</div>
	);
};

export default Main;
