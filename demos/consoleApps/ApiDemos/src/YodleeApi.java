import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YodleeApi {

    // client id, client secret and login username are needed to send token request
    public static final String CLIENT_ID = "";
    public static final String CLIENT_SECRET = "";

    // login username is one of the 5 predefined usernames that come with the Yodlee sandbox
    public static final String LOGIN_USERNAME = "";

    // Yodlee Sandbox url
    public static final String API_URL = "https://sandbox.api.yodlee.uk/ysl";

    // version must be part of the request's header
    public static final String API_VERSION = "1.1";

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {

        // regex for extracting the access token from the token request response body
        String regex = "(?<=\"accessToken\":[\\s*]\")(?<token>.*)(?=\",)";
        Pattern pattern = Pattern.compile(regex);
        String tokenString = getAccessToken(API_URL);

        System.out.println("******************************* TOKEN DETAILS *******************************");
        System.out.println(tokenString);
        System.out.println();

        Matcher matcher = pattern.matcher(tokenString);
        String token = matcher.find() ? matcher.group("token") : "no match";

        if (!token.equals("no match")) {

            System.out.println("******************************* TOKEN *******************************");
            System.out.println(token);
            System.out.println();

            System.out.println("******************************* ACCOUNTS *******************************");
            System.out.println(getAccounts(API_URL, token));
            System.out.println();

            String accountId = "10017406";
            System.out.println("******************************* ACCOUNT DETAILS *******************************");
            System.out.println(getAccountDetails(API_URL, token, accountId));
            System.out.println();

            System.out.println("******************************* TRANSACTIONS *******************************");
            System.out.println(getTransactions(API_URL, token));
            System.out.println();

            System.out.println("******************************* HOLDINGS *******************************");
            System.out.println(getHoldings(API_URL, token));
            System.out.println();

        } else {
            System.out.println("Token could not be extracted from the token details! " +
                    "Check regex and token details JSON response!");
        }


    }

    // Send POST request to retrieve access token. Token is valid for 30 minutes
    private static String getAccessToken(String url) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + "/auth/token"))
                .header("Api-Version", API_VERSION)
                .header("loginName", LOGIN_USERNAME)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("clientId=" + CLIENT_ID + "&secret=" + CLIENT_SECRET))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        return response.body();
    }

    // This method sends a GET request which returns information about accounts added by the user.
    private static String getAccounts(String url, String token) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + "/accounts"))
                .header("Api-Version", API_VERSION)
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


    // This method sends a GET request which returns information about a specific account.
    private static String getAccountDetails(String url, String token, String accountId) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + "/accounts/" + accountId))
                .header("Api-Version", API_VERSION)
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    // This method sends a GET request which returns a list of user's transactions. No information is returned for the test users.
    private static String getTransactions(String url, String token) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + "/transactions"))
                .header("Api-Version", API_VERSION)
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }

    // This method sends a GET request which returns a list of the user's holdings i.e. stock, mutual fund, etc.
    private static String getHoldings(String url, String token) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url + "/holdings"))
                .header("Api-Version", API_VERSION)
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }
}
