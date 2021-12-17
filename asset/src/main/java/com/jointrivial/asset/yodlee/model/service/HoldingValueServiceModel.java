package com.jointrivial.asset.yodlee.model.service;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class HoldingValueServiceModel {

    @Expose
    private BigDecimal amount;

    @Expose
    private String currency;

    public HoldingValueServiceModel() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
