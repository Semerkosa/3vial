package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the account data from Yodlee's JSON response
// Not all fields are included in order to keep the structure simple

public class Account {

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

    @Expose
    private Balance balance = new Balance("GBP", 0);

    public Account() {
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountID: " + getId() + "\n" +
                "AccountName: " + getAccountName() + "\n" +
                "AccountType: " + getAccountType() + "\n" +
                "ProviderName: " + getProviderName() + "\n" +
                "Balance: " + getBalance();
    }
}
