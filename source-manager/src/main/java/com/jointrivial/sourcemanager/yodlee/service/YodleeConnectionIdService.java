package com.jointrivial.sourcemanager.yodlee.service;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface YodleeConnectionIdService {

    String getYodleeAuthenticationToken(String userId) throws InterruptedException, IOException, URISyntaxException;
    List<String> getYodleeAccountsByRequestId(String requestId, String userId, String providerAccountId) throws InterruptedException, IOException, URISyntaxException;
}
