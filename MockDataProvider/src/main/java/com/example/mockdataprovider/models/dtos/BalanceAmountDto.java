package com.example.mockdataprovider.models.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class BalanceAmountDto {
    @Expose
    private BigDecimal amount;
    @Expose
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
