package io.trivial.models.services;

import io.trivial.models.entites.Privilege;

import javax.persistence.*;
import java.util.Collection;

public class RoleServiceModel {

    private String name;
    private Collection<PrivilegeServiceModel> privileges;

    public RoleServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<PrivilegeServiceModel> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<PrivilegeServiceModel> privileges) {
        this.privileges = privileges;
    }
}
