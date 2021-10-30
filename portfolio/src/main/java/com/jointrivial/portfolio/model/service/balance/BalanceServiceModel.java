package com.jointrivial.portfolio.model.service.balance;

public class BalanceServiceModel {

    private BalanceAmountServiceModel balanceAmount;

    public BalanceAmountServiceModel getBalanceAmount() {
        return balanceAmount;
    }

    public BalanceServiceModel setBalanceAmount(BalanceAmountServiceModel balanceAmount) {
        this.balanceAmount = balanceAmount;
        return this;
    }
}
