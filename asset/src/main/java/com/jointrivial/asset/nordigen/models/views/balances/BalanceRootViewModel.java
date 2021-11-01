package com.jointrivial.asset.nordigen.models.views.balances;

import com.google.gson.annotations.Expose;

import java.util.List;

public class BalanceRootViewModel {

    @Expose
    private String organizationName;
    @Expose
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
