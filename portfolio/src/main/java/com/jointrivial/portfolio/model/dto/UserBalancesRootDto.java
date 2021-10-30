package com.jointrivial.portfolio.model.dto;

import java.util.List;

public class UserBalancesRootDto {

    private List<BalancesRootDto> userBalances;

    public List<BalancesRootDto> getUserBalances() {
        return userBalances;
    }

    public UserBalancesRootDto setUserBalances(List<BalancesRootDto> userBalances) {
        this.userBalances = userBalances;
        return this;
    }
}
