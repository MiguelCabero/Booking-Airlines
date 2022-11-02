import Layout from './Layout';
import { Routes, BrowserRouter, Route } from 'react-router-dom';
import Main from './Components/Main';

function App() {
	return (
		<Layout>
			<BrowserRouter>
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
			</BrowserRouter>
		</Layout>
	);
}

export default App;
