import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import CountryList from './Components/CountryListComponent/CountryList';
import reportWebVitals from './reportWebVitals';
import DatesForm from './Components/DatesFormComponent/DatesForm';
import ResultsForm from './Components/ResultsFormComponent/ResultsForm';
import UserForm from './Components/UserInfoComponent/UserForm';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
	<React.StrictMode>
		<App />
		<CountryList action={'origin'} />
		<DatesForm
			origin='Seville'
			destination='Barcelona'
		/>
		<ResultsForm
			airlines={[
				{ id: 1, name: 'Iberia' },
				{ id: 2, name: 'Emirates' },
			]}
			dates={[
				'11/11/2022',
				'12/11/2022',
				'13/11/2022',
				'14/11/2022',
				'15/11/2022',
			]}
			results={[
				{
					companyName: {
						name: 'Ryanair',
						id: 1,
					},
					flightNumber: 123,
					date: '11/11/2022',
					time: '12:00h',
					duration: '1h',
					layover: 'No',
					lugagge: 'No',
					price: '80€',
				},
				{
					companyName: {
						name: 'Ryanair',
						id: 1,
					},
					flightNumber: 123,
					date: '11/11/2022',
					time: '12:00h',
					duration: '1h',
					layover: 'No',
					lugagge: 'No',
					price: '80€',
				},
			]}
		/>

		<UserForm />
	</React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
