package io.trivial.models.view;

import java.util.List;

public class RoleViewModel {

    private String name;
    private List<PrivilegeViewModel> privileges;

    public RoleViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PrivilegeViewModel> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeViewModel> privileges) {
        this.privileges = privileges;
    }

}
