package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the holding value (currency and amount) data from Yodlee's JSON response

public class HoldingValue {

    @Expose
    private double amount;

    @Expose
    private String currency;

    public HoldingValue() {
    }

    public HoldingValue(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Currency: " + getCurrency() + " " + "Amount " + getAmount();
    }
}
