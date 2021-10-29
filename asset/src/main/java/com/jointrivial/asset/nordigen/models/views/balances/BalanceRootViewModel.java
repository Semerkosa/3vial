package com.jointrivial.asset.nordigen.models.views.balances;

import com.google.gson.annotations.Expose;

import java.util.List;

public class BalanceRootViewModel {
    @Expose
    private List<BalanceViewModel> balances;

    public List<BalanceViewModel> getBalances() {
        return balances;
    }

    public BalanceRootViewModel setBalances(List<BalanceViewModel> balances) {
        this.balances = balances;
        return this;
    }
}
