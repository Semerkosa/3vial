package com.jointrivial.sourcemanager.yodlee.model.deserializer;

import com.google.gson.annotations.Expose;

public class AccountDeserializeModel {

    @Expose
    private int id;

    @Expose
    private String accountName;

    @Expose
    private String providerName;

    @Expose
    private int providerId;

    @Expose
    private int providerAccountId;

    @Expose
    private String accountType;

    public AccountDeserializeModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getProviderAccountId() {
        return providerAccountId;
    }

    public void setProviderAccountId(int providerAccountId) {
        this.providerAccountId = providerAccountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
