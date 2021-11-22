package com.jointrivial.asset.nordigen.api;

import com.jointrivial.asset.nordigen.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NordigenAccountInfoAPI {

    private static final String ACCOUNT_URL = "/api/v2/accounts/";

    @Autowired
    private ApplicationProperties properties;

    public String getAccountMetadata(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(baseUrl() + ACCOUNT_URL + accountId + "/");
    }

    public String getAccountBalances(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(baseUrl() + ACCOUNT_URL + accountId + "/balances/");
    }

    public String getAccountDetails(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(baseUrl() + ACCOUNT_URL + accountId + "/details/");
    }

    public String getAccountTransactions(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(baseUrl() + ACCOUNT_URL + accountId + "/transactions/");
    }

    private String baseUrl() {
        return this.properties.getBaseUrl();
    }

    private String token() {
        return "Bearer " + this.properties.getAccessToken();
    }

    private String baseGetHttpRequest(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", token())
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        }

        // TODO handle exception properly
        return null;
    }
}
