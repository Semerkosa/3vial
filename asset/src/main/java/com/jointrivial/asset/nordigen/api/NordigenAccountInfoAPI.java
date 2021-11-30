package com.jointrivial.asset.nordigen.api;

import java.io.IOException;

import static com.jointrivial.asset.nordigen.constants.ApiURLs.ACCOUNT_URL;

public class NordigenAccountInfoAPI extends BaseNordigen{

    public String getAccountMetadata(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ACCOUNT_URL + accountId + "/");
    }

    public String getAccountBalances(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ACCOUNT_URL + accountId + "/balances/");
    }

    public String getAccountDetails(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ACCOUNT_URL + accountId + "/details/");
    }

    public String getAccountTransactions(String accountId) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ACCOUNT_URL + accountId + "/transactions/");
    }
}
