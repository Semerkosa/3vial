package io.trivial.models.services;

import javax.persistence.Column;

public class PrivilegeServiceModel {

    private String name;

    public PrivilegeServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
