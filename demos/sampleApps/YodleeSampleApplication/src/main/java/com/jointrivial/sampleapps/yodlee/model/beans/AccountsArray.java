package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the account data array from Yodlee's JSON response

public class AccountsArray {

    @Expose
    private Account[] account;

    public AccountsArray() {
    }

    public Account[] getAccount() {
        return account;
    }

    public void setAccount(Account[] account) {
        this.account = account;
    }
}
