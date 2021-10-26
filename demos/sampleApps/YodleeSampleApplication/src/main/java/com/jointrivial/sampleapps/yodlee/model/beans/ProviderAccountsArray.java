package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the provider account array data from Yodlee's JSON response

public class ProviderAccountsArray {

    @Expose
    private ProviderAccount[] providerAccount;

    public ProviderAccountsArray() {
    }

    public ProviderAccount[] getProviderAccount() {
        return providerAccount;
    }

    public void setProviderAccount(ProviderAccount[] providerAccount) {
        this.providerAccount = providerAccount;
    }
}
