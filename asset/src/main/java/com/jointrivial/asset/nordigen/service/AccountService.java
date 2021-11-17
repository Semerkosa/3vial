package com.jointrivial.asset.nordigen.service;

import com.jointrivial.asset.nordigen.models.views.balances.UserBalancesViewModel;

import java.io.IOException;

public interface AccountService {

    UserBalancesViewModel getUserBalances(String keyOrganizationJson) throws IOException, InterruptedException;
}
