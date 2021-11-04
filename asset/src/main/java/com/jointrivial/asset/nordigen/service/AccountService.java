package com.jointrivial.asset.nordigen.service;

import com.jointrivial.asset.nordigen.models.views.balances.UserBalancesViewModel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AccountService {

    UserBalancesViewModel getUserBalances(String keyOrganizationJson) throws IOException, InterruptedException;
}
