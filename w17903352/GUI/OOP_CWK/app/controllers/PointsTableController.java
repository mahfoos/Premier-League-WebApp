package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.Controller;
import play.mvc.Result;
import services.PointsTableService;
import utils.ResponseUtil;


public class PointsTableController extends Controller {

    public Result pointsTableData() {

        PointsTableService.loadTheData();
        ObjectMapper objectMap = new ObjectMapper();
        JsonNode dataOfJson = objectMap.convertValue(PointsTableService.listOfServiceSportsClubs, JsonNode.class);
        return created(ResponseUtil.createResponse(dataOfJson, true));

    }

}
