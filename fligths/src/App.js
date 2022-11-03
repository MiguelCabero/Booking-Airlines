import Layout from './Layout';
import { Routes, BrowserRouter, Route } from 'react-router-dom';
import Main from './Components/Main';
import NotFound from './NotFound/NotFoundComponent';

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
					path='*'
					exact={true}
					element={<NotFound />}
				/>
			</Routes>
		</Layout>
	);
}

export default App;
