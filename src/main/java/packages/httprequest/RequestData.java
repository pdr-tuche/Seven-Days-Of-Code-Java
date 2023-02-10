package packages.httprequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestData {
    private final String API_PATH = "/sport/football/team/search";
    private final String PERSONAL_API_KEY = System.getenv("PERSONAL_API_KEY");
    private String response;

    public RequestData() {
    }

    public RequestData(String teamName) throws IOException, InterruptedException {
        String teamNameFormatted = replaceSpaces(teamName);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("http://api.isportsapi.com" + API_PATH + "?api_key=" + PERSONAL_API_KEY + teamNameFormatted))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        this.response = response.body();
    }

    public static String replaceSpaces(String teamName) {
        String formattedName;
        if (teamName.contains(" ")) {
            formattedName= teamName.replaceAll(" ", "%20");
            return "&name="+formattedName;
        }
        return "&name="+teamName;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
