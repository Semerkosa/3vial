package com.jointrivial.portfolio.model.dto;

public class BalanceDto {

    private BalanceAmountDto balanceAmount;

    public BalanceAmountDto getBalanceAmount() {
        return balanceAmount;
    }

    public BalanceDto setBalanceAmount(BalanceAmountDto balanceAmount) {
        this.balanceAmount = balanceAmount;
        return this;
    }
}
