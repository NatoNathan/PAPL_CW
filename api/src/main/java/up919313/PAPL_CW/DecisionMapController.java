package up919313.PAPL_CW;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.ArrayList;


@RestController
public class DecisionMapController {

	DecisionMap decisionMap;
	
	@GetMapping("start")
	public SimpleNode start(){
		return new SimpleNode(decisionMap.getHead());
	}
	@GetMapping("next/{nodeID}")
	public SimpleNode next(@PathVariable("nodeID") int nodeID){
		return new SimpleNode(decisionMap.pickNode(nodeID));
	}
	
	@PostConstruct
	private void loadDecisionMap(){
		JSONParser jsonParser = new JSONParser();
		ArrayList<JsonNode> nodes = new ArrayList<>();

		try (FileReader reader = new FileReader("CW_map.json"))
		{
			//Read JSON file
			Object obj = jsonParser.parse(reader);


			JSONArray jsonArrayNodes = (JSONArray) obj;
			jsonArrayNodes.forEach(n -> {
				JsonNode node =  new JsonNode((JSONObject) n);
				nodes.add(node);
			});
			this.decisionMap = new DecisionMap(nodes.toArray(JsonNode[]::new));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
