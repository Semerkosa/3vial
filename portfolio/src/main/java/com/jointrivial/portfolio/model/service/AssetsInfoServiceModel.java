package com.jointrivial.portfolio.model.service;

import java.math.BigDecimal;

public class AssetsInfoServiceModel {

    private String currencyType;
    private BigDecimal amount;

    public AssetsInfoServiceModel() {
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public AssetsInfoServiceModel setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public AssetsInfoServiceModel setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
}
