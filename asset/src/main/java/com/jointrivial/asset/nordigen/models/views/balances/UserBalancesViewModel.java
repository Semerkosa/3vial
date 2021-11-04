package com.jointrivial.asset.nordigen.models.views.balances;

import java.util.ArrayList;
import java.util.List;

public class UserBalancesViewModel {

    private List<BalanceRootViewModel> userBalances;

    public UserBalancesViewModel() {
        this.userBalances = new ArrayList<>();
    }

    public List<BalanceRootViewModel> getUserBalances() {
        return userBalances;
    }

    public UserBalancesViewModel setUserBalances(List<BalanceRootViewModel> userBalances) {
        this.userBalances = userBalances;
        return this;
    }

    public void addBalances(BalanceRootViewModel balanceRootViewModel) {
        this.userBalances.add(balanceRootViewModel);
    }
}
