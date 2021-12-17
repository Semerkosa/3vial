package com.jointrivial.sourcemanager.yodlee.service.impl;

import com.google.gson.Gson;
import com.jointrivial.sourcemanager.config.ApplicationProperties;
import com.jointrivial.sourcemanager.yodlee.api.YodleeApi;
import com.jointrivial.sourcemanager.yodlee.api.model.response.YodleeResponse;
import com.jointrivial.sourcemanager.yodlee.model.deserializer.AccountDeserializeModel;
import com.jointrivial.sourcemanager.yodlee.model.deserializer.AccountsArrayDeserializeModel;
import com.jointrivial.sourcemanager.yodlee.model.entity.YodleeConnectionId;
import com.jointrivial.sourcemanager.yodlee.repository.YodleeConnectionIdRepository;
import com.jointrivial.sourcemanager.yodlee.service.YodleeConnectionIdService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class YodleeConnectionIdServiceImpl implements YodleeConnectionIdService {

    private final YodleeConnectionIdRepository yodleeConnectionIdRepository;
    private final YodleeApi yodleeApi;
    private final ApplicationProperties appProperties;
    private final Gson gson;

    public YodleeConnectionIdServiceImpl(YodleeConnectionIdRepository yodleeConnectionIdRepository,
                                         YodleeApi yodleeApi,
                                         ApplicationProperties appProperties, Gson gson) {
        this.yodleeConnectionIdRepository = yodleeConnectionIdRepository;
        this.yodleeApi = yodleeApi;
        this.appProperties = appProperties;
        this.gson = gson;
    }

    @Override
    public String getYodleeAuthenticationToken(String userId) throws InterruptedException, IOException, URISyntaxException {

        YodleeConnectionId connectionId = yodleeConnectionIdRepository.getByUserId(userId);

        if (connectionId == null) {
            connectionId = registerUser(userId);
        }

        String userLoginName = connectionId.getLoginName();

        String accessToken = yodleeApi.getAccessToken(userLoginName);

        // ToDo Add custom exception and handle in global handler
        if (accessToken == null) {
            throw new RuntimeException("Yodlee authentication failed!");
        }

        return accessToken;
    }

    @Override
    public List<String> getYodleeAccountsByRequestId(String requestId, String userId, String providerAccountId) throws InterruptedException, IOException, URISyntaxException {

        List<String> listAccountIds = new ArrayList<>();

        YodleeConnectionId connectionId = yodleeConnectionIdRepository.getByUserId(userId);

        String yodleeToken = yodleeApi.getAccessToken(connectionId.getLoginName());

        YodleeResponse response = yodleeApi.getUserAccountsByRequestId(requestId, yodleeToken, providerAccountId);

        if (response.getStatusCode() == 200) {

            AccountsArrayDeserializeModel arrAccounts =
                    gson.fromJson(response.getBody(), AccountsArrayDeserializeModel.class);

            for (AccountDeserializeModel account : arrAccounts.getAccount()) {
                listAccountIds.add(String.valueOf(account.getId()));
            }

            return listAccountIds;

        } else {
            
            // ToDo Add custom exception and handle in global handler
            throw new RuntimeException("Yodlee accounts could not be retrieved!");
        }

    }

    private YodleeConnectionId registerUser(String userId) throws InterruptedException, IOException, URISyntaxException {

        String generatedLoginName = "login_" + userId;
        String adminToken = yodleeApi.getAccessToken(appProperties.getYodleeAdminLoginName());

        // ToDo Add custom exception and handle in global handler
        if (adminToken == null) {
            throw new RuntimeException("Yodlee authentication failed!");
        }

        String userData = "{\"user\":{\"loginName\":\"" + generatedLoginName + "\"}}";

        YodleeResponse userRegisterResponse =
                yodleeApi.registerUser(userData, adminToken);

        if (userRegisterResponse.getStatusCode() == 200) {

            YodleeConnectionId newConnectionId = new YodleeConnectionId();
            newConnectionId.setUserId(userId);
            newConnectionId.setLoginName(generatedLoginName);

            return yodleeConnectionIdRepository.save(newConnectionId);

        } else {
            // ToDo Add custom exception and handle in global handler
            throw new RuntimeException("User could not be registered in Yodlee!" +
                    userRegisterResponse.getBody());
        }


    }
}
