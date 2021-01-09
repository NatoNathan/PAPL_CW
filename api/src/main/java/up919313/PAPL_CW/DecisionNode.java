package up919313.PAPL_CW;

public class DecisionNode {
	private int nodeId;
	private String nodeText;
	private DecisionNode[] linkedNodes;
	private int[] linkedNodeIds;
	private NodeType nodeType;

	public DecisionNode(int nodeId, String nodeText, NodeType nodeType, int[] linkedNodeIds) {
		this.nodeId = nodeId;
		this.nodeText = nodeText;
		this.nodeType = nodeType;
		this.linkedNodeIds = linkedNodeIds;
		this.linkedNodes = new DecisionNode[linkedNodeIds.length];
	}

	public int getNodeId() {
		return nodeId;
	}

	public String getNodeText() {
		return nodeText;
	}

	public DecisionNode[] getLinkedNodes() {
		return linkedNodes;
	}

	public NodeType getNodeType() {
		return nodeType;
	}
}
