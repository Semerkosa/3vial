package com.jointrivial.sourcemanager.yodlee.service;

import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface AccountService {

    String getUserIdByToken(String userToken) throws URISyntaxException, IOException, InterruptedException;
    HttpStatus saveAccounts(String userToken, List<String> accountIds, String provider);
}
