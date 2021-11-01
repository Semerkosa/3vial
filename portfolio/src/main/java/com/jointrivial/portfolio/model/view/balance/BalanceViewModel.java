package com.jointrivial.portfolio.model.view.balance;

public class BalanceViewModel {

    private BalanceAmountViewModel balanceAmount;

    public BalanceAmountViewModel getBalanceAmount() {
        return balanceAmount;
    }

    public BalanceViewModel setBalanceAmount(BalanceAmountViewModel balanceAmount) {
        this.balanceAmount = balanceAmount;
        return this;
    }
}
