package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class ResponseUtil {

	public static ObjectNode createResponse(Object response, boolean ok) {
		ObjectNode outputOfResult = Json.newObject();
		outputOfResult.put("status", ok);
		if (response instanceof String)
			outputOfResult.put("response", (String) response);
		else outputOfResult.set("response", (JsonNode) response);

		return outputOfResult;
	}
}
