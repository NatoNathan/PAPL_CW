import { Component } from "react";
import Message from "../components/Message";
import Messages from "../components/Messages";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { faPaperPlane } from '@fortawesome/free-solid-svg-icons';


class GameView extends Component {
	constructor(props) {
		super(props);
		this.handleResponse = this.handleResponse.bind(this);
		this.state = {
			data: [],
			lastMessage: {}
		};

	}
	componentDidMount() {
		this.handleResponse(null);
	}

	handleResponse(nodeID) {
		let path
		if (nodeID === null) {
			path = '/api/start';

		} else {
			path = `/api/next/${nodeID}`
		}
		this.sendRequest(path).then(newMessage => {
			this.setState((state, props) => ({ data: [...state.data, newMessage], lastMessage: newMessage }));
			console.log(newMessage)
			if (newMessage.responses.length === 1) {
				this.handleResponse(newMessage.responses[0].nodeID);
			}
		});
	}

	sendRequest(path) {
		return fetch(path).then(function (response) {
			if (response.status !== 200) {
				throw Error(response.statusText);
			}
			return response.json();
		}).catch(e => { console.error(e) })
	}



	render() {
		return <div className=" flex flex-col flex-none h-full">
			<Messages items={this.state.data} />
			<div className="justify-self-end flex-shrink-0 mb-20">
				<Response onResponse={this.handleResponse} responses={this.state.lastMessage.responses} />
				<Reply />
			</div>
		</div>
	}
}

export default GameView;

class Response extends Component {
	constructor(props) {
		super(props);
		this.handleResponse = this.handleResponse.bind(this);
	}

	handleResponse(nodeid) {
		this.props.onResponse(nodeid)
	}
	render() {
		if (this.props.responses) {
			return <div className="flex flex-row-6 flex-wrap justify-evenly ">
				{this.props.responses.map(
					item => <Message
						key={item.nodeID}
						nodeid={item.nodeID}
						type="response"
						onTap={e => this.handleResponse(e)}
					>{item.nodeText}</Message>
				)}
			</div>
		} else {
			return <div className="flex flex-row-6 justify-evenly "></div>
		}
	}
}

class Reply extends Component {
	render() {
		return <div className="w-full mb-3 flex flex-row items-center p-1">
			<input type="text" className="rounded-full py-3 px-6 w-full" />
			<FontAwesomeIcon className="mx-2 text-gray-800" icon={faPaperPlane} size="2x" />
		</div>
	}
}