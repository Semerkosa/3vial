package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the account balance data from Yodlee's JSON response

public class Balance {

    @Expose
    private String currency;

    @Expose
    private double amount;

    public Balance() {
    }

    public Balance(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Currency: " + getCurrency() + " " + "Amount: " + getAmount();
    }
}
