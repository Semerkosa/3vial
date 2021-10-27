package com.jointrivial.portfolio.model.dto;

import java.math.BigDecimal;

public class BalanceAmountDto {

    private BigDecimal amount;
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public BalanceAmountDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public BalanceAmountDto setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
