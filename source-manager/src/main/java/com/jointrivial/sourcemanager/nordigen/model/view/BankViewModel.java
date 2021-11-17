package com.jointrivial.sourcemanager.nordigen.model.view;

public class BankViewModel extends BaseViewModel {

    private String name;

    public BankViewModel() {
    }

    public BankViewModel(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BankViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
