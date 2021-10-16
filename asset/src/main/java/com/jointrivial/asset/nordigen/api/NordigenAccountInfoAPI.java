package com.jointrivial.asset.nordigen.api;

import java.io.IOException;
import java.net.*;
import java.net.http.*;

import static com.jointrivial.asset.nordigen.constants.ApiURLs.*;

public class NordigenAccountInfoAPI {

    // The Nordigen responses are always in JSON format
    private static final HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> response;
    private static HttpRequest request;

    // country's 2-digit code(bg, de, gb, ro....). There are some exceptions(gb == gbr, both work)
    public String getAllBanksForCountry(String country) throws IOException, InterruptedException {
        return baseHttpRequestGetMethod(GET_ALL_BANKS_FOR_COUNTRY_URL + country);
    }

    // this step could be skipped
    // by default history data is retrieved for the past 90 days
    public String createEndUserAgreement(String userId, String bankId, int maxHistoricalDays) throws URISyntaxException, IOException, InterruptedException {
        String bodyUrlEncodedString = String.format(
                "max_historical_days=%d&enduser_id=%s&aspsp_id=%s", maxHistoricalDays, userId, bankId);

        request = HttpRequest.newBuilder()
                .uri(URI.create(END_USER_AGREEMENT_URL))
                .headers("Authorization", "Token 8ebcc40fa36d43bbfc13326817fa42a5824f481a",
                        "Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(bodyUrlEncodedString))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            return response.body();
        }

        // TODO exc handler
        return null;
    }

    // 2 more parameters can be set in the URL:
    // - limit(the number of results to return per page)
    // - offset(the initial index from which to return the results)
    public String getAllEndUserAgreementsForUserByUserId(String id) throws IOException, InterruptedException {
        return baseHttpRequestGetMethod(ALL_END_USER_AGREEMENTS_BY_USER_ID_URL + id);
    }

    public String getEndUserAgreementById(String id) throws IOException, InterruptedException {
        return baseHttpRequestGetMethod(END_USER_AGREEMENT_URL + id + "/");
    }

    public void deleteEndUserAgreementById(String id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(END_USER_AGREEMENT_URL + id + "/"))
                .header("Authorization", "Token 8ebcc40fa36d43bbfc13326817fa42a5824f481a")
                .DELETE()
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private String baseHttpRequestGetMethod(String url) throws IOException, InterruptedException {

        // HTTP/2 protocol, by default. Another version could be defined.
        request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Token 8ebcc40fa36d43bbfc13326817fa42a5824f481a")
                .GET()
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        }

        // TODO handle exception properly
        return null;
    }
}
