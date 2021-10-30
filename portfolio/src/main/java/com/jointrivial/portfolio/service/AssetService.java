package com.jointrivial.portfolio.service;

import com.jointrivial.portfolio.model.dto.BalancesRootDto;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AssetService {

    BalancesRootDto getAllBalances(String keyOrganizations) throws URISyntaxException, IOException, InterruptedException;
}
