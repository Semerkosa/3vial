package com.jointrivial.sourcemanager.yodlee.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jointrivial.sourcemanager.yodlee.model.deserializer.UserDetailsDeserializeModel;
import com.jointrivial.sourcemanager.yodlee.service.AccountService;
import okhttp3.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

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

    @Override
    public HttpStatus saveAccounts(String userToken, List<String> accountIds, String provider) {

        JsonArray jsonArray = new JsonArray();

        for (String accountId : accountIds) {
            JsonObject providerApiKey = new JsonObject();
            providerApiKey.addProperty("organizationName", provider);
            providerApiKey.addProperty("organizationKey", accountId);
            jsonArray.add(providerApiKey);
        }

        JsonObject keysOrganisationJson = new JsonObject();
        keysOrganisationJson.add("keysOrganisation",jsonArray);

        String json = new Gson().toJson(keysOrganisationJson);
        json = json.replaceAll("\\\\","");
        json = json.replace("\"[", "[");
        json = json.replace("]\"", "]");

        OkHttpClient accountService = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request post_provider_api_keys = new Request.Builder()
                .url("http://localhost:8084/user/account/provider_api_keys")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Token", userToken)
                .build();

        Response response;
        try {
            response = accountService.newCall(post_provider_api_keys).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.valueOf(response.code());

    }
}
