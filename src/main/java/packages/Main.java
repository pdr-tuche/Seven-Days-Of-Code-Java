package packages;

import org.json.JSONException;
import packages.createjson.WriteJson;
import packages.httprequest.RequestData;
import packages.interact.AskTeamToSearch;
import packages.jsonparser.MyJsonParser;
import packages.model.JsonModel;
import packages.model.TeamData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        AskTeamToSearch askTeamToSearch = new AskTeamToSearch();
        String teamToSearch = askTeamToSearch.getTeamName();

        RequestData requestData = new RequestData(teamToSearch);
        String json = requestData.getResponse();
        // parsing json into objects
        MyJsonParser parsedJson = new MyJsonParser(json);
        JsonModel jsonModel = parsedJson.getJsonModel();

        TeamData team = jsonModel.getTeamData(teamToSearch);
        try {
            WriteJson jsonreturn = new WriteJson(team);
            System.out.println(jsonreturn.getJsonObject());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}