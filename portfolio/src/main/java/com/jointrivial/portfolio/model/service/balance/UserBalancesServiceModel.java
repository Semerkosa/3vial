package com.jointrivial.portfolio.model.service.balance;

import java.util.List;

public class UserBalancesServiceModel {

    private List<BalanceRootServiceModel> userBalances;

    public List<BalanceRootServiceModel> getUserBalances() {
        return userBalances;
    }

    public UserBalancesServiceModel setUserBalances(List<BalanceRootServiceModel> userBalances) {
        this.userBalances = userBalances;
        return this;
    }

    @Override
    public String toString() {
        String balances = "";
        for (BalanceRootServiceModel userBalance : userBalances) {
            balances += userBalance + ", ";
        }
        return "UserBalancesServiceModel{" +
                "userBalances=" + balances +
                '}';
    }
}
