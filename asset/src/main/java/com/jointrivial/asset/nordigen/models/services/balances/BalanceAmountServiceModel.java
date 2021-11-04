package com.jointrivial.asset.nordigen.models.services.balances;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class BalanceAmountServiceModel {
    @Expose
    private BigDecimal amount;
    @Expose
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public BalanceAmountServiceModel setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public BalanceAmountServiceModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
