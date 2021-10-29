package com.jointrivial.asset.nordigen.models.views;

public abstract class BaseViewModel {

    private String id;

    public BaseViewModel() {
    }

    public BaseViewModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public BaseViewModel setId(String id) {
        this.id = id;
        return this;
    }
}
