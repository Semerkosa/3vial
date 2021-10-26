package com.jointrivial.sampleapps.yodlee.model.view;

import java.util.List;

public class ProviderAccountViewModel {

    private int id;
    private List<AccountViewModel> accounts;

    public ProviderAccountViewModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AccountViewModel> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountViewModel> accounts) {
        this.accounts = accounts;
    }

}
