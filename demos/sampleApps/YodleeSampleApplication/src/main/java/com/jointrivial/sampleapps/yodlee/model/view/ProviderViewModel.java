package com.jointrivial.sampleapps.yodlee.model.view;

import java.util.List;

public class ProviderViewModel {

    private int id;
    private String name;
    private List<ProviderAccountViewModel> providerAccounts;

    public ProviderViewModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProviderAccountViewModel> getProviderAccounts() {
        return providerAccounts;
    }

    public void setProviderAccounts(List<ProviderAccountViewModel> providerAccounts) {
        this.providerAccounts = providerAccounts;
    }


}
