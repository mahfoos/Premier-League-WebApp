package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.Result;
import services.DateService;
import services.PointsTableService;
import utils.ResponseUtil;

import static play.mvc.Results.created;


public class MatchTableController {

	public Result MatchTableData() {
		PointsTableService.loadTheData();
		ObjectMapper objectMap = new ObjectMapper();
		JsonNode dataOfJson = objectMap.convertValue(PointsTableService.listOfServiceMatches, JsonNode.class);
		return created(ResponseUtil.createResponse(dataOfJson,true));

	}

	public Result RandomTableData() {

		PointsTableService.get();
		ObjectMapper objectMap = new ObjectMapper();
		JsonNode dataOfJson = objectMap.convertValue(PointsTableService.listOfServiceMatches, JsonNode.class);
		return created(ResponseUtil.createResponse(dataOfJson, true));

	}

	public Result SortedDate() {

		DateService.getDate();
		ObjectMapper objectMap = new ObjectMapper();
		JsonNode dataOfJson = objectMap.convertValue(PointsTableService.listOfServiceMatches, JsonNode.class);
		return created(ResponseUtil.createResponse(dataOfJson, true));

	}

}
