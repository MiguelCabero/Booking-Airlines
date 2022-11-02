import Country from './Country';
import './CountryList.component.css';
function CountryList(props) {
	return (
		<div className='countryList'>
			<h2>Select your {props.action}</h2>
			<Country
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
			/>
		</div>
	);
}

export default CountryList;
