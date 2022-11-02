import './Country.component.css';
function Country(props) {
	function getFlagEmoji(countryCode) {
		const codePoints = countryCode
			.toUpperCase()
			.split('')
			.map((char) => 127397 + char.charCodeAt());
		return String.fromCodePoint(...codePoints);
	}
	return (
		<div className='countryContainer'>
			<button className='country'>
				{props.name} {getFlagEmoji(props.countryCode)}
			</button>
		</div>
	);
}

export default Country;
