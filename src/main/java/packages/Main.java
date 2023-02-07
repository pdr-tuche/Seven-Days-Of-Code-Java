package packages;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Main {

    private static final String API_PATH = "/sport/football/livescores";
    private static final String PERSONAL_API_KEY = System.getenv("PERSONAL_API_KEY");
    private static final String POST_API_URL = "http://api.isportsapi.com/"+API_PATH+"?api_key="+PERSONAL_API_KEY;
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(POST_API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}