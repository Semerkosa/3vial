package com.example.mockdataprovider.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class BalancesRootDto {

    @Expose
    private List<BalanceDto> balances;

    public List<BalanceDto> getBalances() {
        return balances;
    }

    public BalancesRootDto setBalances(List<BalanceDto> balances) {
        this.balances = balances;
        return this;
    }
}
