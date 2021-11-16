package com.jointrivial.sourcemanager.nordigen.model.service;

import com.google.gson.annotations.Expose;

public abstract class BaseServiceModel {

    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public BaseServiceModel setId(String id) {
        this.id = id;
        return this;
    }
}
