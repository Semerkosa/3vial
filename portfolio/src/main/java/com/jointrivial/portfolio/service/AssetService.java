package com.jointrivial.portfolio.service;

import com.jointrivial.portfolio.model.dto.BalanceRootDto;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AssetService {

    BalanceRootDto getAllBalances(String keyOrganizations) throws URISyntaxException, IOException, InterruptedException;
}
