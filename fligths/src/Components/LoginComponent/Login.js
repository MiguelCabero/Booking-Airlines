import { React, useRef } from 'react';
import './Login.component.css';

const Login = () => {
	const emailRef = useRef(null);
	const passwordRef = useRef(null);

	return (
		<div className='login-form'>
			<form action>
				<div className='input-container'>
					<label htmlFor='email'>Email: </label>
					<input
						type='email'
						placeholder='Email'
						name='email'
						ref={emailRef}
					/>
				</div>
				<div className='input-container'>
					<label htmlFor='password'>Password: </label>
					<input
						type='password'
						placeholder='Password'
						name='password'
						ref={passwordRef}
					/>
				</div>
				<div className='submit-container'>
					<input
						type='submit'
						defaultValue='Accept'
					/>
				</div>
			</form>
		</div>
	);
};

export default Login;
