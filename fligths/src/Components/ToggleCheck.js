import './ToggleCheck.component.css';

function ToggleCheck(props) {
	return (
		<div className='checkbox-toggle'>
			<label className='toggler-wrapper'>
				<input
					type='checkbox'
					name={`${props.action}${props.index}`}
				/>
				<div className='toggler-slider'>
					<div className='toggler-knob' />
				</div>
			</label>
			<div className='badge'>{props.label}</div>
		</div>
	);
}

export default ToggleCheck;
