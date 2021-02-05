import { Component } from "react";
import { Link } from "react-router-dom";
import { Avatar } from "../components/Header";

class StartView extends Component {
	render() {
		return <div className="flex flex-col">
			<Link to="/game">
				<div className="card h-14 mt-2 bg-gray-200 flex-row flex items-center">
					<Avatar />
					<h3 className="p-2 font-bold">Unknown Number</h3>
					<p>Hey, Hey,</p>
				</div>
			</Link>

		</div>;
	}
}

export default StartView;