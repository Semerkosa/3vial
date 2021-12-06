package com.jointrivial.asset.nordigen.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jointrivial.asset.nordigen.config.ApplicationProperties;
import com.jointrivial.asset.nordigen.models.services.NordigenAccessTokenServiceModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.jointrivial.asset.nordigen.constants.ApiURLs.*;

public abstract class BaseNordigen {

    // The Nordigen's responses are always in JSON format
    private static final HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> response;
    private static HttpRequest request;

    @Autowired
    private ApplicationProperties properties;

    protected String getBaseUrl() {
        return this.properties.getBaseUrl();
    }

    protected String baseGetHttpRequest(String url) throws IOException, InterruptedException {

        // HTTP/2 protocol, by default. Another version could be defined.
        request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", getAccessToken())
                .GET()
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        }

        // TODO handle exception properly
        return null;
    }

    protected String getAccessToken() throws IOException, InterruptedException {
        String secretId = this.properties.getSecretId();
        String secretKey = this.properties.getSecretKey();

        String bodyUrlEncodedString = String.format(
                "secret_id=%s&secret_key=%s", secretId, secretKey);

        request = HttpRequest.newBuilder()
                .uri(URI.create(getBaseUrl() +  GET_ACCESS_TOKEN_URL))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(bodyUrlEncodedString))
                .build();

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting().create();

            NordigenAccessTokenServiceModel tokenServiceModel = gson.fromJson(response.body(), NordigenAccessTokenServiceModel.class);

            return "Bearer " + tokenServiceModel.getAccess();
        }

        // TODO exception handling
        return null;
    }
}
