package com.jointrivial.sourcemanager.yodlee.service.impl;

import com.jointrivial.sourcemanager.config.ApplicationProperties;
import com.jointrivial.sourcemanager.yodlee.api.YodleeApi;
import com.jointrivial.sourcemanager.yodlee.api.model.response.YodleeResponse;
import com.jointrivial.sourcemanager.yodlee.model.entity.YodleeConnectionId;
import com.jointrivial.sourcemanager.yodlee.repository.YodleeConnectionIdRepository;
import com.jointrivial.sourcemanager.yodlee.service.YodleeConnectionIdService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class YodleeConnectionIdServiceImpl implements YodleeConnectionIdService {

    private final YodleeConnectionIdRepository yodleeConnectionIdRepository;
    private final YodleeApi yodleeApi;
    private final ApplicationProperties appProperties;

    public YodleeConnectionIdServiceImpl(YodleeConnectionIdRepository yodleeConnectionIdRepository,
                                         YodleeApi yodleeApi,
                                         ApplicationProperties appProperties) {
        this.yodleeConnectionIdRepository = yodleeConnectionIdRepository;
        this.yodleeApi = yodleeApi;
        this.appProperties = appProperties;
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
        if(accessToken == null) {
            throw new RuntimeException("Yodlee authentication failed!");
        }

        return accessToken;
    }

    private YodleeConnectionId registerUser(String userId) throws InterruptedException, IOException, URISyntaxException {

        String generatedLoginName = "login_" + userId;
        String adminToken = yodleeApi.getAccessToken(appProperties.getYodleeAdminLoginName());

        // ToDo Add custom exception and handle in global handler
        if(adminToken == null) {
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
