package com.jointrivial.sampleapps.yodlee.model.view;

public class HoldingValueViewModel {

    private String currency;
    private double amount;

    public HoldingValueViewModel() {
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
}
