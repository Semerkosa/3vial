package com.jointrivial.asset.nordigen.models.services.balances;

import com.google.gson.annotations.Expose;

import java.util.List;

public class BalanceRootServiceModel {

    @Expose
    private List<BalanceServiceModel> balances;

    public List<BalanceServiceModel> getBalances() {
        return balances;
    }

    public BalanceRootServiceModel setBalances(List<BalanceServiceModel> balances) {
        this.balances = balances;
        return this;
    }
}
