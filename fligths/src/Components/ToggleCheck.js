import './ToggleCheck.component.css';
import { React } from 'react';

function ToggleCheck(props) {
	return (
		<div className='checkbox-toggle'>
			<label className='toggler-wrapper'>
				<input
					type='checkbox'
					name={`${props.action}${props.index}`}
					checked={props.checked}
					onChange={props.onChange}
					ref={props.reference}
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
