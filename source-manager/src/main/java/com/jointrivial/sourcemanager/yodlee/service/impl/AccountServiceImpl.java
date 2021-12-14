package com.jointrivial.sourcemanager.yodlee.service.impl;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.yodlee.model.deserializer.UserDetailsDeserializeModel;
import com.jointrivial.sourcemanager.yodlee.service.AccountService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AccountServiceImpl implements AccountService {

    private static final String ACCOUNT_URL = "http://localhost:8084/user";
    private final Gson gson;

    public AccountServiceImpl(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String getUserIdByToken(String userToken) throws URISyntaxException, IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ACCOUNT_URL))
                .header("User-Token", userToken)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        UserDetailsDeserializeModel userDetails =
                gson.fromJson(response.body(), UserDetailsDeserializeModel.class);

        return userDetails.getId();

    }
}
