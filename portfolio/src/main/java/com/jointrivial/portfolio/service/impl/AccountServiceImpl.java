package com.jointrivial.portfolio.service.impl;

import com.jointrivial.portfolio.exceptions.IllegalUserTokenException;
import com.jointrivial.portfolio.service.AccountService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AccountServiceImpl implements AccountService {
    private static final String ACCOUNT_URL = "http://localhost:8084/user/account/provider_api_keys";

    @Override
    public String getAllKeyOrganizations(String userToken) throws IOException, InterruptedException, URISyntaxException {
        if (userToken == null || userToken.isEmpty() || userToken.isBlank()) {
            throw new IllegalUserTokenException("User token is empty!");
        }
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(ACCOUNT_URL))
                .header("User-Token", userToken)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
