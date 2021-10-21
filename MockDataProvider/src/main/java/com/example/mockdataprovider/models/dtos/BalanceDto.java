package com.example.mockdataprovider.models.dtos;

import com.google.gson.annotations.Expose;

public class BalanceDto {
    @Expose
    private BalanceAmountDto balanceAmount;

    public BalanceAmountDto getBalanceAmount() {
        return balanceAmount;
    }

    public BalanceDto setBalanceAmount(BalanceAmountDto balanceAmount) {
        this.balanceAmount = balanceAmount;
        return this;
    }
}
