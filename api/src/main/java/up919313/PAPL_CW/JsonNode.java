package up919313.PAPL_CW;

public class JsonNode {
	private int node_id;
	private String node_text;
	private int[] linked_nodes;
	private NodeType nodeType;

	public JsonNode(int node_id, String node_text, int[] linked_nodes, String nodeType) {
		this.node_id = node_id;
		this.node_text = node_text;
		this.linked_nodes = linked_nodes;
		this.nodeType = getNodeTypeFromString(nodeType);
	}

	public int getNode_id() {
		return node_id;
	}

	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}

	public String getNode_text() {
		return node_text;
	}

	public void setNode_text(String node_text) {
		this.node_text = node_text;
	}

	public int[] getLinked_nodes() {
		return linked_nodes;
	}

	public void setLinked_nodes(int[] linked_nodes) {
		this.linked_nodes = linked_nodes;
	}

	public NodeType getNodeType() {
		return nodeType;
	}

	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	private static NodeType getNodeTypeFromString(String nodeType){
		switch (nodeType){
			case "action":
				return NodeType.ACTION;
			case "end":
				return NodeType.END;
			case "sent":
				return NodeType.SENT;
			case "received":
			default:
				return NodeType.RECEIVED;

		}
	}
}
