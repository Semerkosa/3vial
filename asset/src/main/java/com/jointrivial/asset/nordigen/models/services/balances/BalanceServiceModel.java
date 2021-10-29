package com.jointrivial.asset.nordigen.models.services.balances;

import com.google.gson.annotations.Expose;

public class BalanceServiceModel {
    @Expose
    private BalanceAmountServiceModel balanceAmount;

    public BalanceAmountServiceModel getBalanceAmount() {
        return balanceAmount;
    }

    public BalanceServiceModel setBalanceAmount(BalanceAmountServiceModel balanceAmount) {
        this.balanceAmount = balanceAmount;
        return this;
    }
}
