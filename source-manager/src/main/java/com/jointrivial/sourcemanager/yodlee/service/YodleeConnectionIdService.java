package com.jointrivial.sourcemanager.yodlee.service;


import java.io.IOException;
import java.net.URISyntaxException;

public interface YodleeConnectionIdService {

    String getYodleeAuthenticationToken(String userId) throws InterruptedException, IOException, URISyntaxException;
}
