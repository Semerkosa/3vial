package com.example.mockdataprovider.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class BalanceRootDto {
    @Expose
    private List<BalanceDto> balances;

    public List<BalanceDto> getBalances() {
        return balances;
    }

    public BalanceRootDto setBalances(List<BalanceDto> balances) {
        this.balances = balances;
        return this;
    }
}
