package com.jointrivial.portfolio.service;

import com.jointrivial.portfolio.model.service.balance.UserBalancesServiceModel;
import com.jointrivial.portfolio.model.view.balance.UserBalancesViewModel;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ReferenceService {
    UserBalancesViewModel calculateAmountInWantedCurrency(String currency, UserBalancesServiceModel balances) throws URISyntaxException, IOException, InterruptedException;
}
