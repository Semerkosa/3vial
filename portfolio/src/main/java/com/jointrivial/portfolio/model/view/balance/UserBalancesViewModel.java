package com.jointrivial.portfolio.model.view.balance;

import java.util.List;

public class UserBalancesViewModel {

    private List<BalanceRootViewModel> userBalances;

    public List<BalanceRootViewModel> getUserBalances() {
        return userBalances;
    }

    public UserBalancesViewModel setUserBalances(List<BalanceRootViewModel> userBalances) {
        this.userBalances = userBalances;
        return this;
    }
}
