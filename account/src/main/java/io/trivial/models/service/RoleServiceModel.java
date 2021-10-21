package io.trivial.models.service;

import java.util.List;

@Deprecated
public class RoleServiceModel {

    private String name;
    private List<PrivilegeServiceModel> privileges;

    public RoleServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PrivilegeServiceModel> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeServiceModel> privileges) {
        this.privileges = privileges;
    }
}
