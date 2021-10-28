package com.example.mockdataprovider.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserBalancesRootDto {

    @Expose
    private List<BalancesRootDto> userBalances;

    public List<BalancesRootDto> getUserBalances() {
        return userBalances;
    }

    public UserBalancesRootDto setUserBalances(List<BalancesRootDto> userBalances) {
        this.userBalances = userBalances;
        return this;
    }
}
