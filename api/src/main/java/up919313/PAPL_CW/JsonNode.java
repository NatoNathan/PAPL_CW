package up919313.PAPL_CW;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonNode {
	private int node_id;
	private String node_text;
	private int[] linked_nodes;
	private NodeType node_type;

	public JsonNode(int node_id, String node_text, int[] linked_nodes, String node_type) {
		this.node_id = node_id;
		this.node_text = node_text;
		this.linked_nodes = linked_nodes;
		this.node_type = getNodeTypeFromString(node_type);
	}

	public JsonNode(JSONObject node){
		this.node_id = (int) node.get("node_id");
		this.node_text = (String) node.get("node_text");
		this.node_type = getNodeTypeFromString((String) node.get("node_type"));
		JSONArray JSONlinkedNodeIds = (JSONArray) node.get("linked_nodes");
		this.linked_nodes = new int[JSONlinkedNodeIds.size()];
		JSONlinkedNodeIds.forEach(id -> this.linked_nodes[JSONlinkedNodeIds.indexOf(id)] = (int) id);
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

	public NodeType getNode_type() {
		return node_type;
	}

	public void setNode_type(NodeType node_type) {
		this.node_type = node_type;
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
