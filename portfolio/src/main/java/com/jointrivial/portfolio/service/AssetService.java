package com.jointrivial.portfolio.service;

import com.jointrivial.portfolio.model.service.balance.UserBalancesServiceModel;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AssetService {

    UserBalancesServiceModel getAllBalances(String keyOrganization) throws URISyntaxException, IOException, InterruptedException;
}
