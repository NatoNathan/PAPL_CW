package up919313.PAPL_CW;

public class SimpleNode {
	private int nodeID;
	private String nodeText;
	private NodeType nodeType;
	private SimpleNode[] responses;
	
	public NodeType getNodeType() {
		return nodeType;
	}
	
	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}
	
	public int getNodeID() {
		return nodeID;
	}
	
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	
	public String getNodeText() {
		return nodeText;
	}
	
	public void setNodeText(String nodeText) {
		this.nodeText = nodeText;
	}
	
	public SimpleNode[] getResponses() {
		return responses;
	}
	
	public void setResponses(SimpleNode[] responses) {
		this.responses = responses;
	}
	
	private SimpleNode(int id, String text, NodeType nodeType){
		this.nodeID = id; this.nodeText = text; this.responses = null; this.nodeType =nodeType;
		
	}
	
	public SimpleNode(DecisionNode node){
		this.nodeID = node.getNodeId();
		this.nodeText = node.getNodeText();
		this.responses = new SimpleNode[node.getLinkedNodes().length];
		this.nodeType = node.getNodeType();
		for (int i = 0; i < responses.length; i++) {
			DecisionNode decisionNode = node.getLinkedNodes()[i];
			this.responses[i] = new SimpleNode(decisionNode.getNodeId(),decisionNode.getNodeText(),decisionNode.getNodeType());
		}
	}
}
