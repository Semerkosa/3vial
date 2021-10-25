package com.jointrivial.portfolio.model.dto;

import java.util.List;

public class BalanceRootDto {

    private List<BalanceDto> balances;

    public List<BalanceDto> getBalances() {
        return balances;
    }

    public BalanceRootDto setBalances(List<BalanceDto> balances) {
        this.balances = balances;
        return this;
    }
}
