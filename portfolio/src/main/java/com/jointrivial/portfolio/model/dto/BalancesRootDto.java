package com.jointrivial.portfolio.model.dto;

import java.util.List;

public class BalancesRootDto {

    private String organizationName;
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
