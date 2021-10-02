package io.trivial.models.binding;

import io.trivial.models.entites.Address;

public class UserUpdateBindingModel {

    private String password;
    private AddressBindingModel address;

    public UserUpdateBindingModel() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressBindingModel getAddress() {
        return address;
    }

    public void setAddress(AddressBindingModel address) {
        this.address = address;
    }
}
