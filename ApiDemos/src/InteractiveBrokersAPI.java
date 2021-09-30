import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class InteractiveBrokersAPI {
    public static void main(String[] args) {
        String id = "";
        try {
            connect(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void connect(String id) throws URISyntaxException, IOException, InterruptedException {
        Properties props = System.getProperties();
        props.setProperty("jdk.internal.httpclient.disableHostnameVerification", "true");
        //Validates the current session for the SSO user
        String validateSessionURL = "https://localhost:5000/v1/api/sso/validate";
        //This endpoint must be called prior to calling other /portfolio endpoints
        String accountsURL = "https://localhost:5000/v1/api/portfolio/accounts";
        //Account information related to account id
        String accountInfoURL = "https://localhost:5000/v1/api/portfolio/%s/meta";
        //Returns information about margin, cash balances and other information related to specified account.
        String portfolioSummaryURL = "https://localhost:5000/v1/api/portfolio/%s/summary";
        //Information regarding settled cash, cash balances, etc. in the account's base currency and any other cash balances hold in other currencies.
        String accountLedgerURL = "https://localhost:5000/v1/api/portfolio/%s/ledger";
        //Logs the user out of the gateway session. Any further activity requires re-authentication.
        String logoutURL = "https://localhost:5000/v1/api/logout";

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest request;
        HttpResponse<String> response;


        System.out.println("Validate session:");
        request = requestBuilder.uri(new URI(validateSessionURL)).GET().build();
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        System.out.println("Portfolio accounts:");
        request = requestBuilder.uri(new URI(accountsURL)).GET().build();
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        System.out.println("Account information:");
        request = requestBuilder.uri(new URI(String.format(accountInfoURL, id))).GET().build();
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        System.out.println("Portfolio summary:");
        request = requestBuilder.uri(new URI(String.format(portfolioSummaryURL, id))).GET().build();
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        System.out.println("Account ledger:");
        request = requestBuilder.uri(new URI(String.format(accountLedgerURL, id))).GET().build();
        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
