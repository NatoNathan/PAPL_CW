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
		this.linkedNodes = null;
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
	
	public int[] getLinkedNodeIds() {
		return linkedNodeIds;
	}
	
	public void buildDecisionNode(DecisionNode[] decisionNodes){
		try {
			this.linkedNodes = new DecisionNode[linkedNodeIds.length];
			for (int i = 0; i < this.linkedNodeIds.length; i++) {
				this.linkedNodes[i] = DecisionMap.findNodeInArray(linkedNodeIds[i], decisionNodes);
				System.out.println(this.toString());
			}
			for (DecisionNode linkedNode : this.linkedNodes) {
				if (linkedNode.linkedNodes == null){
					linkedNode.buildDecisionNode(decisionNodes);
				}
			}
		} catch (NodeNotFoundException e){
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	
	@Override
	public String toString() {
		String nodeIDs = "\nlinkedNodeIDs: {";
		for (int id:this.linkedNodeIds) {
			nodeIDs += id + ",";
		}
		nodeIDs += "}";
		
		return "\n-------\nNodeId: " + this.nodeId + "\nNodeText: " + this.nodeText +"\nNodeType: " + this.nodeType + nodeIDs;
	}
}
