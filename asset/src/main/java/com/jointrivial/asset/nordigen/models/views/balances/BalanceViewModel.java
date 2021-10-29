package com.jointrivial.asset.nordigen.models.views.balances;

import com.google.gson.annotations.Expose;

public class BalanceViewModel {
    @Expose
    private BalanceAmountViewModel balanceAmount;

    public BalanceAmountViewModel getBalanceAmount() {
        return balanceAmount;
    }

    public BalanceViewModel setBalanceAmount(BalanceAmountViewModel balanceAmount) {
        this.balanceAmount = balanceAmount;
        return this;
    }
}
