import { Component } from "react";
import { Link, Switch, Route } from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUserCircle, faPhoneAlt, faVideo, faChevronLeft } from '@fortawesome/free-solid-svg-icons';

export default class Header extends Component {
	render() {
		return <div className="h-16 w-screen font-bold bg-gray-700 header mx-auto grid grid-cols-6 grid-rows-1 place-items-center">
			<Switch>
				<Route path="/game">
					<Back />
					<div className="col-start-2 col-span-3 flex flex-row justify-center items-center">
						<Avatar />
						<h2>Unknown Number</h2>
					</div>
					<Call />
				</Route>
				<Route path="/">
					<h1 className="col-start-2 col-span-4 text-xl">SMS</h1>
				</Route>
			</Switch>

		</div>;
	}
}


export function Avatar() {
	return <FontAwesomeIcon className="p-1.5" icon={faUserCircle} size="3x" />;
}
function Back() {
	return <Link to="/">
		<FontAwesomeIcon className="p-1.5" icon={faChevronLeft} size="3x" />
	</Link>;
}
function Call() {
	return <>
		<FontAwesomeIcon className="p-1.5" icon={faPhoneAlt} size="2x" />
		<FontAwesomeIcon className="p-1.5" icon={faVideo} size="2x" />
	</>
}