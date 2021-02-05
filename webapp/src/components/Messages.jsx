import React from 'react'
import autoscroll from 'autoscroll-react'
import Message from './Message'

class Messages extends React.Component {
	render() {
		const { items, ...props } = this.props
		return (
			<div className="flex flex-col h-full flex-grow-0 justify-self-stretch self-stretch overflow-y-auto overscroll-contain"{...props} >{
				items.map(
					(item, index) => <Message
						key={index}
						nodeid={items.nodeID}
						type={item.nodeType}
					>{item.nodeText}</Message>
				)
			}</div>
		)
	}
}

export default autoscroll(Messages)