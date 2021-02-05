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
	public static final String APPLICATION_JSON_UTF8_VALUE = "application/json";
	@GetMapping(value="api/start",  produces = APPLICATION_JSON_UTF8_VALUE)
	public SimpleNode start(){
		this.loadDecisionMap();
		return new SimpleNode(decisionMap.getHead());
	}
	@GetMapping(value="api/next/{nodeID}",  produces = APPLICATION_JSON_UTF8_VALUE)
	public SimpleNode next(@PathVariable("nodeID") int nodeID){
		return new SimpleNode(decisionMap.pickNode(nodeID));
	}
	
	@PostConstruct
	private void loadDecisionMap(){
		JSONParser jsonParser = new JSONParser();
		ArrayList<JsonNode> nodes = new ArrayList<>();

		try (FileReader reader = new FileReader("newMap.json"))
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
