package io.trivial.models.services;

import io.trivial.models.entites.Address;
import io.trivial.models.entites.Role;

import java.util.Collection;

public class UserServiceModel extends BaseServiceModel {

    private String email;
    private String password;
    private AddressServiceModel address;
    private Collection<RoleServiceModel> roles;

    public UserServiceModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressServiceModel getAddress() {
        return address;
    }

    public void setAddress(AddressServiceModel address) {
        this.address = address;
    }

    public Collection<RoleServiceModel> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleServiceModel> roles) {
        this.roles = roles;
    }
}
