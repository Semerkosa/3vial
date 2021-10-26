package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the provider (bank, broker, etc.) data from Yodlee's JSON response
// Not all fields are included in order to keep the structure simple

public class Provider {

    @Expose
    private int id;

    @Expose
    private String name;

    public Provider() {
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
}
