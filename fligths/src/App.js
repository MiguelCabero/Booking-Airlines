import Layout from './Layout';
import { Routes, BrowserRouter, Route } from 'react-router-dom';
import Main from './Components/Main';

function App() {
	return (
		<Layout>
			<Routes>
				<Route
					path='/'
					exact={true}
					element={<Main />}
				/>
				<Route
					path='/hola'
					exact={true}
					element={<Main />}
				/>
			</Routes>
		</Layout>
	);
}

export default App;
