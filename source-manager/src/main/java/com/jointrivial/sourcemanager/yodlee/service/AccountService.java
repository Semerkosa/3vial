package com.jointrivial.sourcemanager.yodlee.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AccountService {

    String getUserIdByToken(String userToken) throws URISyntaxException, IOException, InterruptedException;
}
