import './ResultItem.component.css';
import AppContext from '../../store/app-context';
import { React, useContext, useRef } from 'react';
import TripContext from '../../store/trip-context';

function ResultItem(props) {
	const currentAppContext = useContext(AppContext);
	const currentTripContext = useContext(TripContext);
	const companyIdRef = useRef(null);
	const layoverRef = useRef(null);
	const dateRef = useRef(null);
	const luggageRef = useRef(null);

	let currentTrips = [...currentTripContext.trips];

	function clickHandler(event) {
		event.preventDefault();
		currentTrips[0].selectedCompany = companyIdRef.current.name;
		currentTrips[0].layover = layoverRef.current.name;
		currentTrips[0].luggage = luggageRef.current.name;
		currentTrips[0].basePrice = props.price.toFixed(2);
		currentAppContext.setStep(++currentAppContext.step);
	}
	return (
		<div className='result-item'>
			<form
				className='item-form'
				onSubmit={clickHandler}>
				<div className='info-inputs'>
					<div className='companyInfo'>
						<label htmlFor={`${props.companyName}${props.index}`}>
							Company{' '}
						</label>
						<input
							type='text'
							name={props.companyId}
							value={`${props.companyName}`}
							ref={companyIdRef}
							className='result-item-element'
							readOnly
						/>
					</div>
					<div className='flighNumber'>
						<label htmlFor={`${props.flightNumber}${props.index}`}>
							Flight number{' '}
						</label>
						<input
							type='text'
							name={`${props.flightNumber}${props.index}`}
							value={`${props.flightNumber}`}
							className='result-item-element'
							readOnly
						/>
					</div>
					<div className='dateInfo'>
						<label htmlFor={`${props.date}${props.index}`}>Date</label>
						<div className='fligth-datetime'>
							<input
								type='text'
								name={`${props.date}${props.index}`}
								value={`${props.date}`}
								ref={dateRef}
								readOnly
							/>
							<input
								type='text'
								name={`${props.time}${props.index}`}
								value={`${props.time}`}
								readOnly
							/>
						</div>
					</div>
					<div id='durationInfo'>
						<label htmlFor={`${props.duration}${props.index}`}>Duration </label>
						<input
							type='text'
							name={`${props.duration}${props.index}`}
							value={`${props.duration}`}
							className='result-item-element'
							readOnly
						/>
					</div>
					<div id='layoverInfo'>
						<label htmlFor={`${props.layover}${props.index}`}>Layover </label>
						<input
							type='text'
							name={props.layover}
							ref={layoverRef}
							value={`${props.layoverText}`}
							className='result-item-element'
							readOnly
						/>
					</div>
					<div id='luggageInfo'>
						<label htmlFor={`${props.luggage}${props.index}`}>Luggage </label>
						<input
							type='text'
							ref={luggageRef}
							name={props.luggage}
							value={`${props.luggageText}`}
							className='result-item-element'
							readOnly
						/>
					</div>
					<div id='priceInfo'>
						<label htmlFor={`${props.price}${props.index}`}>Price </label>
						<input
							type='text'
							name={`${props.price}${props.index}`}
							value={`${props.price.toFixed(2)} €`}
							className='result-item-element'
							readOnly
						/>
					</div>
				</div>
				<input
					type='submit'
					name='select-option'
					className='select-item-element'
					value='Select'
				/>
			</form>
		</div>
	);
}

export default ResultItem;
