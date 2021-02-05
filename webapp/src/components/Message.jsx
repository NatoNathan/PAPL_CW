import { Component } from 'react';


export default class Message extends Component {
	render() {
		switch (this.props.type.toLowerCase()) {
			case "received":
				return <div className="message rounded-full self-start py-2 px-5 max-w-xs bg-gray-100 w-max m-4">
					{this.props.children}
				</div>;
			case "response":
				return <div onClick={e => this.props.onTap(this.props.nodeid)} className="message rounded-lg p-1 bg-green-300 w-max mx-1 my-2">
					{this.props.children}
				</div>;

			case "sent":
			default:
				return <div className="message rounded-full self-end py-2 px-5 max-w-md bg-blue-500 w-max m-3">
					{this.props.children}
				</div>;
		}
	}
}