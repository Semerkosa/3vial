package com.jointrivial.portfolio.service.impl;

import com.google.gson.Gson;
import com.jointrivial.portfolio.exceptions.IllegalInputDataForAssetsException;
import com.jointrivial.portfolio.model.service.balance.UserBalancesServiceModel;
import com.jointrivial.portfolio.service.AssetService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AssetServiceImpl implements AssetService {

    private static final String BALANCES_URL = "http://localhost:8082/asset/balances";

    private final Gson gson;

    public AssetServiceImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public UserBalancesServiceModel getAllBalances(String keyOrganization) throws URISyntaxException, IOException, InterruptedException {
        if (keyOrganization == null || keyOrganization.isEmpty() || keyOrganization.isBlank()) {
            throw new IllegalInputDataForAssetsException("Invalid key-organization!");
        }
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BALANCES_URL))
                .header("Key-Organization", keyOrganization)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), UserBalancesServiceModel.class);
    }
}
