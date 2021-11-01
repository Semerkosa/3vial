package com.jointrivial.portfolio.model.view.balance;

import java.math.BigDecimal;

public class BalanceAmountViewModel {

    private BigDecimal amount;
    private String currency;
    private BigDecimal amountInWantedCurrency;

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

    public BigDecimal getAmountInWantedCurrency() {
        return amountInWantedCurrency;
    }

    public BalanceAmountViewModel setAmountInWantedCurrency(BigDecimal amountInWantedCurrency) {
        this.amountInWantedCurrency = amountInWantedCurrency;
        return this;
    }
}
