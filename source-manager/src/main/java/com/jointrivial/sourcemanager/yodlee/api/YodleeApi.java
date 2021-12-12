package com.jointrivial.sourcemanager.yodlee.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jointrivial.sourcemanager.config.ApplicationProperties;
import com.jointrivial.sourcemanager.yodlee.api.model.response.YodleeResponse;
import com.jointrivial.sourcemanager.yodlee.model.deserializer.AccessTokenDeserializeModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class YodleeApi {

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static HttpResponse<String> response;
    private static HttpRequest request;

    @Autowired
    private ApplicationProperties properties;

    private static final String API_VERSION = "1.1";
    private static final String TOKEN_URI = "/auth/token";
    public static final String REGISTER_URI = "/user/register";
    public static final String ACCOUNTS_URI = "/accounts";

    private String getBaseUrl() {
        return properties.getYodleeBaseUrl();
    }

    /**
     * Generates a token to access Yodlee's endpoints.
     * @param loginName the unique identifier of the user in Yodlee
     * @return the token
     */
    private String getAccessToken(String loginName) throws URISyntaxException, IOException, InterruptedException {

        String clientId = properties.getYodleeClientId();
        String clientSecret = properties.getYodleeSecret();

        String bodyUrlEncodedString = String.format(
                "clientId=%s&secret=%s", clientId, clientSecret);

        request = HttpRequest.newBuilder()
                .uri(new URI(getBaseUrl() + TOKEN_URI))
                .header("loginName", loginName)
                .header("Api-Version", API_VERSION)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(bodyUrlEncodedString))
                .build();

        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        if (response.statusCode() == 201) {
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting().create();

            AccessTokenDeserializeModel accessTokenSerialized =
                    gson.fromJson(response.body(), AccessTokenDeserializeModel.class);

            return accessTokenSerialized.getToken().getAccessToken();
        }

        return null;

    }

    /**
     * Registers the user in Yodlee. Every use has to be registered with a login name
     * which will be the unique identifier that Yodlee uses to distinguish the different users.
     * @param userData the data (in JSON) format that Yodlee accepts for a to-be registered user.
     *                 Currently only loginName is necessary. For example:
     *                 {
     *                  "user": {
     *                              "loginName": "trivial_testUser1"
     *                          }
     *                  }
     * @param loginName the unique identifier of the user in Yodlee
     * @return Object with two properties:
     *          statusCode - the code of the response from Yodlee
     *          body - the body of the response from Yodlee
     */
    public YodleeResponse registerUser(String userData, String loginName) throws URISyntaxException, IOException, InterruptedException {


        request = HttpRequest.newBuilder()
                .uri(new URI(getBaseUrl() + REGISTER_URI))
                .header("Authorization", "Bearer " + getAccessToken(loginName))
                .header("Api-Version", API_VERSION)
                .POST(HttpRequest.BodyPublishers.ofString(userData))
                .build();

        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return new YodleeResponse(response.statusCode(), response.body());

    }

    /**
     * Gets all accounts that correspond to the user identified by the loginName.
     * @param loginName the unique identifier of the user in Yodlee
     * @return Object with two properties:
     *          statusCode - the code of the response from Yodlee
     *          body - the body of the response from Yodlee
     */
    public YodleeResponse getUserAccounts(String loginName) throws InterruptedException, IOException, URISyntaxException {

        request = HttpRequest.newBuilder()
                .uri(new URI(getBaseUrl() + ACCOUNTS_URI))
                .header("Authorization", "Bearer " + getAccessToken(loginName))
                .header("Api-Version", API_VERSION)
                .GET()
                .build();

        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return new YodleeResponse(response.statusCode(), response.body());
    }

    /**
     * Gets the accounts that correspond to the user identified by the loginName
     * and to the request id which is returned when the accounts are successfully linked.
     * When the user links his source (broker, bank) a new request id is created.
     * @param requestId the unique identifier of the accounts linked
     * @param loginName the unique identifier of the user in Yodlee
     * @return Object with two properties:
     *          statusCode - the code of the response from Yodlee
     *          body - the body of the response from Yodlee
     */
    public YodleeResponse getUserAccountsByRequestId(String requestId, String loginName) throws URISyntaxException, IOException, InterruptedException {

        String queryParam = "?requestId=" + requestId;

        request = HttpRequest.newBuilder()
                .uri(new URI(getBaseUrl() + ACCOUNTS_URI + queryParam))
                .header("Authorization", "Bearer " + getAccessToken(loginName))
                .header("Api-Version", API_VERSION)
                .GET()
                .build();

        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return new YodleeResponse(response.statusCode(), response.body());

    }
}
