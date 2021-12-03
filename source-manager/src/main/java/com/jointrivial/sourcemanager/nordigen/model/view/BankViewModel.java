package com.jointrivial.sourcemanager.nordigen.model.view;

public class BankViewModel extends BaseViewModel {

    private String name;
    private String logo;

    public BankViewModel() {
    }

    public BankViewModel(String id, String name, String logo) {
        super(id);
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public BankViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public BankViewModel setLogo(String logo) {
        this.logo = logo;
        return this;
    }
}
