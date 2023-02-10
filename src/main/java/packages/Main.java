package packages;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import packages.model.JsonModel;
import packages.model.TeamData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {

    private static final String API_PATH = "/sport/football/team/search";
    private static final String PERSONAL_API_KEY = System.getenv("PERSONAL_API_KEY");
    private static final String TEAM_NAME = "&name=Ibis%20SC";
    private static final String TEAM_ID = "&teamID=30699";
    private static final String SEARCH_FOR_ID_URL = "http://api.isportsapi.com/"+API_PATH+"?api_key="+PERSONAL_API_KEY+TEAM_ID;
    private static final String SEARCH_FOR_NAME_URL = "http://api.isportsapi.com/"+API_PATH+"?api_key="+PERSONAL_API_KEY+TEAM_NAME;
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(SEARCH_FOR_NAME_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // parsing json into objects
        String json = response.body();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonModel jsonModel = mapper.readValue(json, JsonModel.class);

        TeamData teamOne = jsonModel.getSpecificData(0);
        TeamData teamTwo = jsonModel.getSpecificData(1);

        System.out.printf("Primeiro time -> %s\n" +
                "Segundo time -> %s", teamOne.getName(), teamTwo.getName());
    }
}