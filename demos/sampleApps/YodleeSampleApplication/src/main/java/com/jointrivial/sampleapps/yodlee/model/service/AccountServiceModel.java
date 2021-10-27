package com.jointrivial.sampleapps.yodlee.model.service;

public class AccountServiceModel {

    private int id;
    private String accountName;
    private String providerName;
    private int providerId;
    private int providerAccountId;
    private String accountType;
    private BalanceServiceModel balance;

    public AccountServiceModel() {
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

    public BalanceServiceModel getBalance() {
        return balance;
    }

    public void setBalance(BalanceServiceModel balance) {
        this.balance = balance;
    }
}
