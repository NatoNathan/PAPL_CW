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

	public DecisionNode buildDecisionNode(DecisionNode[] decisionNodes){
		for (int i = 0; i < this.linkedNodeIds.length ; i++) {
			DecisionNode linkedNode = decisionNodes[i];
			try {
				this.linkedNodes[i] = DecisionMap.findNodeInArray(linkedNode.getNodeId(), decisionNodes);
				this.linkedNodes[i].buildDecisionNode(decisionNodes);
			} catch (NodeNotFoundException e){
				System.out.println(e.getMessage());
			}
		}

		return this;
	}
}
