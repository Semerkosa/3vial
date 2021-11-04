package com.jointrivial.portfolio.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AccountService {

    String getAllKeyOrganizations(String userToken) throws IOException, InterruptedException, URISyntaxException;
}
