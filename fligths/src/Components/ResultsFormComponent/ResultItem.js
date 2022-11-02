import './ResultItem.component.css';

function ResultItem(props) {
	return (
		<div className='result-item'>
			<form
				className='item-form'
				onSubmit={props.onSubmit}>
				<div className='info-inputs'>
					<div className='companyInfo'>
						<label htmlFor={`${props.companyName}${props.index}`}>
							Company{' '}
						</label>
						<input
							type='text'
							name={`${props.companyName}${props.index}`}
							defaultValue={`${props.companyName}`}
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
							defaultValue={`${props.flightNumber}`}
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
								defaultValue={`${props.date}`}
								readOnly
							/>
							<input
								type='text'
								name={`${props.time}${props.index}`}
								defaultValue={`${props.time}`}
								readOnly
							/>
						</div>
					</div>
					<div id='durationInfo'>
						<label htmlFor={`${props.duration}${props.index}`}>Duration </label>
						<input
							type='text'
							name={`${props.duration}${props.index}`}
							defaultValue={`${props.duration}`}
							className='result-item-element'
							readOnly
						/>
					</div>
					<div id='layoverInfo'>
						<label htmlFor={`${props.layover}${props.index}`}>Layover </label>
						<input
							type='text'
							name={`${props.layover}${props.index}`}
							defaultValue={`${props.layover}`}
							className='result-item-element'
							readOnly
						/>
					</div>
					<div id='luggageInfo'>
						<label htmlFor={`${props.lugagge}${props.index}`}>Luggage </label>
						<input
							type='text'
							name={`${props.lugagge}${props.index}`}
							defaultValue={`${props.lugagge}`}
							className='result-item-element'
							readOnly
						/>
					</div>
					<div id='priceInfo'>
						<label htmlFor={`${props.price}${props.index}`}>Price </label>
						<input
							type='text'
							name={`${props.price}${props.index}`}
							defaultValue={`${props.price}`}
							className='result-item-element'
							readOnly
						/>
					</div>
				</div>
				<input
					type='submit'
					name='select-option'
					defaultValue='Select'
					className='select-item-element'
				/>
			</form>
		</div>
	);
}

export default ResultItem;
