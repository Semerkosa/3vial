package com.jointrivial.portfolio.model.service.balance;

import java.util.List;

public class UserBalancesRootServiceModel {

    private List<BalancesRootServiceModel> userBalances;

    public List<BalancesRootServiceModel> getUserBalances() {
        return userBalances;
    }

    public UserBalancesRootServiceModel setUserBalances(List<BalancesRootServiceModel> userBalances) {
        this.userBalances = userBalances;
        return this;
    }
}
