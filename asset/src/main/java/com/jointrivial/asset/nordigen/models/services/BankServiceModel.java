package com.jointrivial.asset.nordigen.models.services;

import com.google.gson.annotations.Expose;

import java.util.List;

// ASPSP = Account Servicing Payment Service Provider(e.g., bank...)
public class BankServiceModel {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String bic;
    @Expose
    private String transactionTotalDays;
    @Expose
    private List<String> countries;
    @Expose
    private String logo;

    public BankServiceModel() {
    }

    public String getId() {
        return id;
    }

    public BankServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BankServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getBic() {
        return bic;
    }

    public BankServiceModel setBic(String bic) {
        this.bic = bic;
        return this;
    }

    public String getTransactionTotalDays() {
        return transactionTotalDays;
    }

    public BankServiceModel setTransactionTotalDays(String transactionTotalDays) {
        this.transactionTotalDays = transactionTotalDays;
        return this;
    }

    public List<String> getCountries() {
        return countries;
    }

    public BankServiceModel setCountries(List<String> countries) {
        this.countries = countries;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public BankServiceModel setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    @Override
    public String toString() {
        return "BankServiceModel --> " +
                "id = " + id +
                ", name = " + name +
                ", bic = " + bic +
                ", transactionTotalDays = " + transactionTotalDays +
                ", countries = " + countries +
                ", logo = " + logo;
    }
}
