package com.jointrivial.asset.nordigen.models.views;

public class BankViewModel {

    private String id;
    private String name;

    public BankViewModel() {
    }

    public BankViewModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public BankViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BankViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
