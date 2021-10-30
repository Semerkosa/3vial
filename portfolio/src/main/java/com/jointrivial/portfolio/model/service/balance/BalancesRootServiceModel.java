package com.jointrivial.portfolio.model.service.balance;

import java.util.List;

public class BalancesRootServiceModel {

    private String organizationName;
    private List<BalanceServiceModel> balances;

    public String getOrganizationName() {
        return organizationName;
    }

    public BalancesRootServiceModel setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public List<BalanceServiceModel> getBalances() {
        return balances;
    }

    public BalancesRootServiceModel setBalances(List<BalanceServiceModel> balances) {
        this.balances = balances;
        return this;
    }
}
