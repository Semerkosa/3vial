package com.jointrivial.asset.nordigen.api;

import com.jointrivial.asset.nordigen.config.ApplicationProperties;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.util.List;

import static com.jointrivial.asset.nordigen.constants.ApiURLs.*;

public class NordigenAccountInfoAPI {

    // The Nordigen responses are always in JSON format
    private static final HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> response;
    private static HttpRequest request;

    @Autowired
    private ApplicationProperties properties;

    // country's 2-digit code(bg, de, gb, ro....). There are some exceptions(gb == gbr, both work)
    public String getAllBanksForCountry(String country) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + GET_ALL_BANKS_FOR_COUNTRY_URL + country);
    }

    // this step could be skipped
    // by default history data is retrieved for the past 90 days
    public String createEndUserAgreement(String userId, String bankId, int maxHistoricalDays) throws URISyntaxException, IOException, InterruptedException {
        String bodyUrlEncodedString = String.format(
                "max_historical_days=%d&enduser_id=%s&aspsp_id=%s", maxHistoricalDays, userId, bankId);

        return basePostHttpRequest(getBaseUrl() + END_USER_AGREEMENT_URL, bodyUrlEncodedString, "application/x-www-form-urlencoded");
    }

    // 2 more parameters can be set in the URL:
    // - limit(the number of results to return per page)
    // - offset(the initial index from which to return the results)
    public String getAllEndUserAgreementsForUserByUserId(String id) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ALL_END_USER_AGREEMENTS_BY_USER_ID_URL + id);
    }

    public String getEndUserAgreementById(String id) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + END_USER_AGREEMENT_URL + id + "/");
    }

    public void deleteEndUserAgreementById(String id) throws IOException, InterruptedException {
        baseDeleteHttpRequest(getBaseUrl() + END_USER_AGREEMENT_URL, id);
    }

    // language could be set in the body
    public String createRequisition(String userId, String referenceId, String redirectUrl, @NotNull List<String> EuaIDs) throws IOException, InterruptedException {
        String bodyJsonString = String.format("{\n" +
                        "\"enduser_id\": \"%s\",\n" +
                        "\"reference\": \"%s\",\n" +
                        "\"redirect\": \"%s\"",
                userId, referenceId, redirectUrl);

        if (!EuaIDs.isEmpty()) {
            StringBuilder sb = new StringBuilder(bodyJsonString);

            sb.append(",\n\"agreements\": [\n");

            EuaIDs.forEach(id -> sb.append(String.format("\"%s\", ", id)));

            sb.replace(sb.length() - 2, sb.length(), "\n]");

            bodyJsonString = sb.toString();
        }

        return basePostHttpRequest(getBaseUrl() + REQUISITION_URL, bodyJsonString + "\n}", "application/json");
    }

    public void deleteRequisitionById(String id) throws IOException, InterruptedException {
        baseDeleteHttpRequest(getBaseUrl() + REQUISITION_URL, id);
    }

    public String getRequisitionById(String id) throws IOException, InterruptedException {
        System.err.println("IN THE \"accounts\" IN THAT RESPONSE ---> ARE THERE ANY ACCOUNT_IDS?");
        return baseGetHttpRequest(getBaseUrl() + REQUISITION_URL + id + "/");
    }

    // 2 more parameters can be set in the URL:
    // - limit(the number of results to return per page)
    // - offset(the initial index from which to return the results)
    public String getAllRequisitions() throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + REQUISITION_URL);
    }

    public String createBankAuthorizationLinkForRequisition(String requisitionId, String bankId) throws IOException, InterruptedException {
        String bodyUrlEncodedString = String.format(
                "aspsp_id=%s", bankId);

        String linkUrl = getBaseUrl() + REQUISITION_URL + requisitionId + "/links/";

        return basePostHttpRequest(linkUrl, bodyUrlEncodedString, "application/x-www-form-urlencoded");
    }

    public String getAccountMetadata(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ACCOUNT_URL + accountId + "/");
    }

    public String getAccountBalances(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ACCOUNT_URL + accountId + "/balances/");
    }

    public String getAccountDetails(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ACCOUNT_URL + accountId + "/details/");
    }

    public String getAccountTransactions(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ACCOUNT_URL + accountId + "/transactions/");
    }

    private String getBaseUrl() {
        return this.properties.getBaseUrl();
    }

    private String basePostHttpRequest(String url, String bodyString, String bodyFormat) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .headers("Authorization", "Token 8ebcc40fa36d43bbfc13326817fa42a5824f481a",
                        "Content-Type", bodyFormat)
                .POST(HttpRequest.BodyPublishers.ofString(bodyString))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201 || response.statusCode() == 200) {
            return response.body();
        }

        // TODO exc handler
        return null;
    }

    private void baseDeleteHttpRequest(String url, String id) throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(URI.create(url + id + "/"))
                .header("Authorization", "Token 8ebcc40fa36d43bbfc13326817fa42a5824f481a")
                .DELETE()
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private String baseGetHttpRequest(String url) throws IOException, InterruptedException {

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
