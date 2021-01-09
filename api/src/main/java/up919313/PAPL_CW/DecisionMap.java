package up919313.PAPL_CW;

import java.util.ArrayList;

public class DecisionMap {
	private DecisionNode head;
	private DecisionNode tail;

	public DecisionMap(JsonNode[] map){

	}

	private DecisionNode[] buildDecisionNodes(JsonNode[] nodes){
		ArrayList<DecisionNode> decisionNodes = new ArrayList<>();
		for (JsonNode node:nodes) {
			decisionNodes.add(new DecisionNode(node.getNode_id(), node.getNode_text(),node.getNodeType(), node.getLinked_nodes()));
		}
		return (DecisionNode[]) decisionNodes.toArray();
	}
	private void buildDecisionMap(DecisionNode[] decisionNodes, JsonNode[] JsonNodes){

	}

//	private DecisionNode getNodeById(int nodeId){
	//}
	private static DecisionNode findNodeInArray(int nodeId, DecisionNode[] decisionNodes) throws NodeNotFoundException{
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

}
