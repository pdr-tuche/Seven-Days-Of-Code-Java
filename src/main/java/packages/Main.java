package packages;

import packages.httprequest.RequestData;
import packages.jsonparser.MyJsonParser;
import packages.model.JsonModel;
import packages.model.TeamData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        RequestData requestData = new RequestData("Ibis SC");
        String json = requestData.getResponse();
        // parsing json into objects
        MyJsonParser parsedJson = new MyJsonParser(json);
        JsonModel jsonModel = parsedJson.getJsonModel();

        TeamData teamOne = jsonModel.getSpecificData(0);
        TeamData teamTwo = jsonModel.getSpecificData(1);

        System.out.printf("Primeiro time -> %s\n" +
                "Segundo time -> %s", teamOne.getName(), teamTwo.getName());
    }
}