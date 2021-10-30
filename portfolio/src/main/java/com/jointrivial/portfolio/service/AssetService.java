package com.jointrivial.portfolio.service;

import com.jointrivial.portfolio.model.service.balance.BalancesRootServiceModel;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AssetService {

    BalancesRootServiceModel getAllBalances(String keyOrganizations) throws URISyntaxException, IOException, InterruptedException;
}
