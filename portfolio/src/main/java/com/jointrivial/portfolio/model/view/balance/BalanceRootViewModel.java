package com.jointrivial.portfolio.model.view.balance;

import java.util.List;

public class BalanceRootViewModel {

    private String organizationName;
    private List<BalanceViewModel> balances;

    public String getOrganizationName() {
        return organizationName;
    }

    public BalanceRootViewModel setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public List<BalanceViewModel> getBalances() {
        return balances;
    }

    public BalanceRootViewModel setBalances(List<BalanceViewModel> balances) {
        this.balances = balances;
        return this;
    }
}
