package packages;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import packages.httprequest.RequestData;
import packages.model.JsonModel;
import packages.model.TeamData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        RequestData requestData = new RequestData("Ibis SC");

        // parsing json into objects
        String json = requestData.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonModel jsonModel = mapper.readValue(json, JsonModel.class);

        TeamData teamOne = jsonModel.getSpecificData(0);
        TeamData teamTwo = jsonModel.getSpecificData(1);

        System.out.printf("Primeiro time -> %s\n" +
                "Segundo time -> %s", teamOne.getName(), teamTwo.getName());
    }
}