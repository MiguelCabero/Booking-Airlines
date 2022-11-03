import { React, useContext, useRef, useState, useEffect } from 'react';
import ToggleCheck from '../ToggleCheck';
import './UserInputs.component.css';
import TripContext from '../../store/trip-context';
import PassengersContext from '../../store/passengers-context';

function UserInputs(props) {
	const currentTripContext = useContext(TripContext);
	const currentPassengersContext = useContext(PassengersContext);
	const [bags, setBags] = useState(
		currentPassengersContext.passengers[props.index].bags == 1
	);
	const nameRef = useRef(null);
	const surNameRef = useRef(null);
	const nationalityRef = useRef(null);
	const identificationRef = useRef(null);
	const ageRef = useRef(null);
	let refBags = currentPassengersContext.passengers[props.index].bags;

	const handleBags = (event) => {
		refBags == 0 ? (refBags = 1) : (refBags = 0);
		props.usersState[props.index] = {
			...props.usersState[props.index],
			bags: refBags,
		};
		currentPassengersContext.setPassengers([...props.usersState]);
		setBags((prevState) => {
			prevState == 0 ? (prevState = 1) : (prevState = 0);
			return prevState;
		});
	};
	const handleChange = (event) => {
		props.usersState[props.index] = {
			...props.usersState[props.index],
			age: ageRef.current.value,
		};

		currentPassengersContext.setPassengers([...props.usersState]);
	};

	function handleDelete(event) {
		event.preventDefault();
		props.usersState.splice(event.target.value, 1);
		currentPassengersContext.setPassengers([...props.usersState]);
		window.location.reload();
	}

	return (
		<div className='passenger-inputs-field'>
			<div className='input-element'>
				<label htmlFor={`user-name${props.index}`}>Name</label>
				<input
					type='text'
					name={`user-name${props.index}`}
					ref={nameRef}
				/>
			</div>
			<div className='input-element'>
				<label htmlFor={`user-surname${props.index}`}>Surname</label>
				<input
					type='text'
					name={`user-surname${props.index}`}
					ref={surNameRef}
				/>
			</div>
			<div className='input-element'>
				<label htmlFor={`user-nationality${props.index}`}>Nationality</label>
				<input
					type='text'
					name={`user-nationality${props.index}`}
					list={`datalist-nationalities${props.index}`}
					ref={nationalityRef}
				/>
				<datalist id={`datalist-nationalities${props.index}`}>
					<select name={`nationality-select${props.index}`}>
						<option value>-- select one --</option>
						<option value='afghan'>Afghan</option>
						<option value='albanian'>Albanian</option>
						<option value='algerian'>Algerian</option>
						<option value='american'>American</option>
						<option value='andorran'>Andorran</option>
						<option value='angolan'>Angolan</option>
						<option value='antiguans'>Antiguans</option>
						<option value='argentinean'>Argentinean</option>
						<option value='armenian'>Armenian</option>
						<option value='australian'>Australian</option>
						<option value='austrian'>Austrian</option>
						<option value='azerbaijani'>Azerbaijani</option>
						<option value='bahamian'>Bahamian</option>
						<option value='bahraini'>Bahraini</option>
						<option value='bangladeshi'>Bangladeshi</option>
						<option value='barbadian'>Barbadian</option>
						<option value='barbudans'>Barbudans</option>
						<option value='batswana'>Batswana</option>
						<option value='belarusian'>Belarusian</option>
						<option value='belgian'>Belgian</option>
						<option value='belizean'>Belizean</option>
						<option value='beninese'>Beninese</option>
						<option value='bhutanese'>Bhutanese</option>
						<option value='bolivian'>Bolivian</option>
						<option value='bosnian'>Bosnian</option>
						<option value='brazilian'>Brazilian</option>
						<option value='british'>British</option>
						<option value='bruneian'>Bruneian</option>
						<option value='bulgarian'>Bulgarian</option>
						<option value='burkinabe'>Burkinabe</option>
						<option value='burmese'>Burmese</option>
						<option value='burundian'>Burundian</option>
						<option value='cambodian'>Cambodian</option>
						<option value='cameroonian'>Cameroonian</option>
						<option value='canadian'>Canadian</option>
						<option value='cape verdean'>Cape Verdean</option>
						<option value='central african'>Central African</option>
						<option value='chadian'>Chadian</option>
						<option value='chilean'>Chilean</option>
						<option value='chinese'>Chinese</option>
						<option value='colombian'>Colombian</option>
						<option value='comoran'>Comoran</option>
						<option value='congolese'>Congolese</option>
						<option value='costa rican'>Costa Rican</option>
						<option value='croatian'>Croatian</option>
						<option value='cuban'>Cuban</option>
						<option value='cypriot'>Cypriot</option>
						<option value='czech'>Czech</option>
						<option value='danish'>Danish</option>
						<option value='djibouti'>Djibouti</option>
						<option value='dominican'>Dominican</option>
						<option value='dutch'>Dutch</option>
						<option value='east timorese'>East Timorese</option>
						<option value='ecuadorean'>Ecuadorean</option>
						<option value='egyptian'>Egyptian</option>
						<option value='emirian'>Emirian</option>
						<option value='equatorial guinean'>Equatorial Guinean</option>
						<option value='eritrean'>Eritrean</option>
						<option value='estonian'>Estonian</option>
						<option value='ethiopian'>Ethiopian</option>
						<option value='fijian'>Fijian</option>
						<option value='filipino'>Filipino</option>
						<option value='finnish'>Finnish</option>
						<option value='french'>French</option>
						<option value='gabonese'>Gabonese</option>
						<option value='gambian'>Gambian</option>
						<option value='georgian'>Georgian</option>
						<option value='german'>German</option>
						<option value='ghanaian'>Ghanaian</option>
						<option value='greek'>Greek</option>
						<option value='grenadian'>Grenadian</option>
						<option value='guatemalan'>Guatemalan</option>
						<option value='guinea-bissauan'>Guinea-Bissauan</option>
						<option value='guinean'>Guinean</option>
						<option value='guyanese'>Guyanese</option>
						<option value='haitian'>Haitian</option>
						<option value='herzegovinian'>Herzegovinian</option>
						<option value='honduran'>Honduran</option>
						<option value='hungarian'>Hungarian</option>
						<option value='icelander'>Icelander</option>
						<option value='indian'>Indian</option>
						<option value='indonesian'>Indonesian</option>
						<option value='iranian'>Iranian</option>
						<option value='iraqi'>Iraqi</option>
						<option value='irish'>Irish</option>
						<option value='israeli'>Israeli</option>
						<option value='italian'>Italian</option>
						<option value='ivorian'>Ivorian</option>
						<option value='jamaican'>Jamaican</option>
						<option value='japanese'>Japanese</option>
						<option value='jordanian'>Jordanian</option>
						<option value='kazakhstani'>Kazakhstani</option>
						<option value='kenyan'>Kenyan</option>
						<option value='kittian and nevisian'>Kittian and Nevisian</option>
						<option value='kuwaiti'>Kuwaiti</option>
						<option value='kyrgyz'>Kyrgyz</option>
						<option value='laotian'>Laotian</option>
						<option value='latvian'>Latvian</option>
						<option value='lebanese'>Lebanese</option>
						<option value='liberian'>Liberian</option>
						<option value='libyan'>Libyan</option>
						<option value='liechtensteiner'>Liechtensteiner</option>
						<option value='lithuanian'>Lithuanian</option>
						<option value='luxembourger'>Luxembourger</option>
						<option value='macedonian'>Macedonian</option>
						<option value='malagasy'>Malagasy</option>
						<option value='malawian'>Malawian</option>
						<option value='malaysian'>Malaysian</option>
						<option value='maldivan'>Maldivan</option>
						<option value='malian'>Malian</option>
						<option value='maltese'>Maltese</option>
						<option value='marshallese'>Marshallese</option>
						<option value='mauritanian'>Mauritanian</option>
						<option value='mauritian'>Mauritian</option>
						<option value='mexican'>Mexican</option>
						<option value='micronesian'>Micronesian</option>
						<option value='moldovan'>Moldovan</option>
						<option value='monacan'>Monacan</option>
						<option value='mongolian'>Mongolian</option>
						<option value='moroccan'>Moroccan</option>
						<option value='mosotho'>Mosotho</option>
						<option value='motswana'>Motswana</option>
						<option value='mozambican'>Mozambican</option>
						<option value='namibian'>Namibian</option>
						<option value='nauruan'>Nauruan</option>
						<option value='nepalese'>Nepalese</option>
						<option value='new zealander'>New Zealander</option>
						<option value='ni-vanuatu'>Ni-Vanuatu</option>
						<option value='nicaraguan'>Nicaraguan</option>
						<option value='nigerien'>Nigerien</option>
						<option value='north korean'>North Korean</option>
						<option value='northern irish'>Northern Irish</option>
						<option value='norwegian'>Norwegian</option>
						<option value='omani'>Omani</option>
						<option value='pakistani'>Pakistani</option>
						<option value='palauan'>Palauan</option>
						<option value='panamanian'>Panamanian</option>
						<option value='papua new guinean'>Papua New Guinean</option>
						<option value='paraguayan'>Paraguayan</option>
						<option value='peruvian'>Peruvian</option>
						<option value='polish'>Polish</option>
						<option value='portuguese'>Portuguese</option>
						<option value='qatari'>Qatari</option>
						<option value='romanian'>Romanian</option>
						<option value='russian'>Russian</option>
						<option value='rwandan'>Rwandan</option>
						<option value='saint lucian'>Saint Lucian</option>
						<option value='salvadoran'>Salvadoran</option>
						<option value='samoan'>Samoan</option>
						<option value='san marinese'>San Marinese</option>
						<option value='sao tomean'>Sao Tomean</option>
						<option value='saudi'>Saudi</option>
						<option value='scottish'>Scottish</option>
						<option value='senegalese'>Senegalese</option>
						<option value='serbian'>Serbian</option>
						<option value='seychellois'>Seychellois</option>
						<option value='sierra leonean'>Sierra Leonean</option>
						<option value='singaporean'>Singaporean</option>
						<option value='slovakian'>Slovakian</option>
						<option value='slovenian'>Slovenian</option>
						<option value='solomon islander'>Solomon Islander</option>
						<option value='somali'>Somali</option>
						<option value='south african'>South African</option>
						<option value='south korean'>South Korean</option>
						<option value='spanish'>Spanish</option>
						<option value='sri lankan'>Sri Lankan</option>
						<option value='sudanese'>Sudanese</option>
						<option value='surinamer'>Surinamer</option>
						<option value='swazi'>Swazi</option>
						<option value='swedish'>Swedish</option>
						<option value='swiss'>Swiss</option>
						<option value='syrian'>Syrian</option>
						<option value='taiwanese'>Taiwanese</option>
						<option value='tajik'>Tajik</option>
						<option value='tanzanian'>Tanzanian</option>
						<option value='thai'>Thai</option>
						<option value='togolese'>Togolese</option>
						<option value='tongan'>Tongan</option>
						<option value='trinidadian or tobagonian'>
							Trinidadian or Tobagonian
						</option>
						<option value='tunisian'>Tunisian</option>
						<option value='turkish'>Turkish</option>
						<option value='tuvaluan'>Tuvaluan</option>
						<option value='ugandan'>Ugandan</option>
						<option value='ukrainian'>Ukrainian</option>
						<option value='uruguayan'>Uruguayan</option>
						<option value='uzbekistani'>Uzbekistani</option>
						<option value='venezuelan'>Venezuelan</option>
						<option value='vietnamese'>Vietnamese</option>
						<option value='welsh'>Welsh</option>
						<option value='yemenite'>Yemenite</option>
						<option value='zambian'>Zambian</option>
						<option value='zimbabwean'>Zimbabwean</option>
					</select>
				</datalist>
			</div>
			<div className='input-element'>
				<label htmlFor={`user-identification${props.index}`}>
					Identification number
				</label>
				<input
					type='text'
					name={`user-identification${props.index}`}
					required
					ref={identificationRef}
				/>
			</div>
			<div className='input-element'>
				<label htmlFor={`passenger-age${props.index}`}>Age</label>
				<select
					name={`passenger-age${props.index}`}
					id='company-filter'
					defaultValue={currentPassengersContext.passengers[props.index].age}
					ref={ageRef}
					onChange={handleChange}>
					<option value={0}>Less than 2 years</option>
					<option value={1}>Between 2 and 9 years</option>
					<option value={2}>More than 9 years</option>
				</select>
			</div>
			{currentTripContext.trip.luggage == 1 ? (
				<ToggleCheck
					label='Bags'
					action='Bags'
					index={props.index}
					checked={true}
				/>
			) : (
				<ToggleCheck
					label='Bags'
					action='Bags'
					checked={bags == 1}
					index={props.index}
					onChange={handleBags}
				/>
			)}

			<div>
				<button
					onClick={handleDelete}
					value={props.index}>
					Delete
				</button>
			</div>
		</div>
	);
}

export default UserInputs;
