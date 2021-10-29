package com.jointrivial.asset.nordigen.service;

import com.jointrivial.asset.nordigen.models.views.balances.BalanceRootViewModel;

import java.io.IOException;
import java.util.List;

public interface AccountService {

    BalanceRootViewModel getAccountBalances(String accountId) throws IOException, InterruptedException;
}
