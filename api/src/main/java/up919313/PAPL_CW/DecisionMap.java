package up919313.PAPL_CW;

import java.util.ArrayList;

public class DecisionMap {
	private DecisionNode head;
	private DecisionNode tail;

	public DecisionMap(JsonNode[] map){
		DecisionNode[] decisionNodes = buildDecisionNodes(map);
		buildDecisionMap(decisionNodes);
	}

	private void buildDecisionMap(DecisionNode[] decisionNodes){
		try {
			this.head = findNodeInArray(0, decisionNodes);
			this.head.buildDecisionNode(decisionNodes);

			this.tail = findNodeInArray(decisionNodes.length -1, decisionNodes);
		} catch (NodeNotFoundException e) {
			System.out.println(e.getMessage());

		}

	}

	public static DecisionNode findNodeInArray(int nodeId, DecisionNode[] decisionNodes) throws NodeNotFoundException{
		int front =0; int back = decisionNodes.length;
		while (front <= back){
			int nodeFrontId = decisionNodes[front].getNodeId();
			int nodeBackId = decisionNodes[back].getNodeId();
			if (nodeBackId == nodeId){
				return decisionNodes[back];
			} else if (nodeFrontId == nodeId){
				return decisionNodes[front];
			}

			front++;
			back--;
		}
		throw new NodeNotFoundException("NodeId:"+nodeId+" not found");
	}

	private static DecisionNode[] buildDecisionNodes(JsonNode[] nodes){
		ArrayList<DecisionNode> decisionNodes = new ArrayList<>();
		for (JsonNode node:nodes) {
			decisionNodes.add(new DecisionNode(node.getNode_id(), node.getNode_text(),node.getNode_type(), node.getLinked_nodes()));
		}
		return (DecisionNode[]) decisionNodes.toArray();
	}

}
