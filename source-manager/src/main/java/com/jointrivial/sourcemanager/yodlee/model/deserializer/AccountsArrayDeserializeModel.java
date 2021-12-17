package com.jointrivial.sourcemanager.yodlee.model.deserializer;

import com.google.gson.annotations.Expose;

public class AccountsArrayDeserializeModel {

    @Expose
    private AccountDeserializeModel[] account;

    public AccountsArrayDeserializeModel() {
    }

    public AccountDeserializeModel[] getAccount() {
        return account;
    }

    public void setAccount(AccountDeserializeModel[] account) {
        this.account = account;
    }
}
