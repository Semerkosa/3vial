package com.jointrivial.portfolio.model.service.balance;

import java.util.ArrayList;
import java.util.List;

public class BalanceRootServiceModel {

    private String organizationName;
    // This is the list of balances for the given organization.
    // Cannot be null.
    private List<BalanceServiceModel> balances = new ArrayList<>();

    public String getOrganizationName() {
        return organizationName;
    }

    public BalanceRootServiceModel setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public List<BalanceServiceModel> getBalances() {
        return balances;
    }

    public BalanceRootServiceModel setBalances(List<BalanceServiceModel> balances) {
        if (balances != null) {
            this.balances = balances;
        }
        return this;
    }

    @Override
    public String toString() {
        String b = "[";
        if (balances != null) {
            for (BalanceServiceModel balance : balances) {
                b += balance + ", ";
            }
        }
        b += "]";
        return "BalanceRootServiceModel{" +
                "organizationName='" + organizationName + '\'' +
                ", balances=" + b +
                '}';
    }
}
