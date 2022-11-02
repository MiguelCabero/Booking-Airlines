import CountryList from './CountryListComponent/CountryList';
import DatesForm from './DatesFormComponent/DatesForm';
import ResultsForm from './ResultsFormComponent/ResultsForm';
import UserForm from './UserInfoComponent/UserInputs';
const Main = (props) => {
	return (
		<div>
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
		</div>
	);
};

export default Main;
