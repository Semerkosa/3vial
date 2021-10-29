package com.jointrivial.asset.nordigen.models.views.balances;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class BalanceAmountViewModel {
    @Expose
    private BigDecimal amount;
    @Expose
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public BalanceAmountViewModel setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public BalanceAmountViewModel setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
