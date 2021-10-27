package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the provider account data from Yodlee's JSON response
// Provider account is the account with which the user logs into the specific provider.
// Not all fields are included in order to keep the structure simple

public class ProviderAccount {

    @Expose
    private int id;

    public ProviderAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
