package com.jointrivial.portfolio.model.service.balance;

import java.math.BigDecimal;

public class BalanceAmountServiceModel {

    private BigDecimal amount;
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

    @Override
    public String toString() {
        return "BalanceAmountServiceModel{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
