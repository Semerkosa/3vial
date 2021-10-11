package com.jointrivial.portfolio.model.view;

import java.math.BigDecimal;

public class AssetsInfoViewModel {

    private String currencyType;
    private BigDecimal amount;

    public AssetsInfoViewModel() {
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public AssetsInfoViewModel setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public AssetsInfoViewModel setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
}
