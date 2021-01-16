package up919313.PAPL_CW;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


@RestController
public class DecisionMapController {

	DecisionMap decisionMap;

	@GetMapping("/decisionmap/setup")
	public void setup(){
		loadDecisionMap();
	}

	@GetMapping("/start")
	public String start(){
		decisionMap
	}

	private void loadDecisionMap(){
		JSONParser jsonParser = new JSONParser();
		ArrayList<JsonNode> nodes = new ArrayList<>();

		try (FileReader reader = new FileReader("decisionMap.json"))
		{
			//Read JSON file
			Object obj = jsonParser.parse(reader);


			JSONArray jsonArraynNodes = (JSONArray) obj;
			jsonArraynNodes.forEach(n -> {
				JsonNode node =  new JsonNode((JSONObject) n);
				nodes.add(node);
			});
			decisionMap = new DecisionMap(nodes.toArray(JsonNode[]::new));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
