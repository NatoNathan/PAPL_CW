import './App.css';
import {
	BrowserRouter as Router,
	Switch,
	Route
} from "react-router-dom";
import GameView from './views/GameView';
import StartView from './views/StartView';
import Header from './components/Header';


function App() {
	return (
		<div className="app mx-auto flex flex-col h-screen w-screen bg-gray-500">
			<Router>
				<Header />
				<Switch>
					<Route path="/game">
						<GameView />
					</Route>
					<Route path="/">
						<StartView />
					</Route>
				</Switch>
			</Router>
		</div>
	);
}

export default App;
