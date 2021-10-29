package com.example.mockdataprovider.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class BalancesRootDto {

    @Expose
    private String organizationName;
    @Expose
    private List<BalanceDto> balances;

    public String getOrganizationName() {
        return organizationName;
    }

    public BalancesRootDto setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public List<BalanceDto> getBalances() {
        return balances;
    }

    public BalancesRootDto setBalances(List<BalanceDto> balances) {
        this.balances = balances;
        return this;
    }
}
