import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NordigenApi {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        printBanksInBulgaria();
    }

    public static void printBanksInBulgaria() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // HTTP/2 protocol, by default. Another version could be defined.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://ob.nordigen.com/api/aspsps/?country=bg"))
                .header("Authorization", "Token 8ebcc40fa36d43bbfc13326817fa42a5824f481a")
                .GET()
                .build();

        // The Nordigen response bodies' are always in JSON format
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int responseCode = response.statusCode();
        String responseBody = response.body();

        System.out.println("Status code: " + responseCode);
        System.out.println("JSON body: " + responseBody);
    }
}
