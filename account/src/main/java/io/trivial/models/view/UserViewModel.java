package io.trivial.models.view;

import io.trivial.models.service.AddressServiceModel;

public class UserViewModel {

    private String email;
    private AddressServiceModel address;

    public UserViewModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressServiceModel getAddress() {
        return address;
    }

    public void setAddress(AddressServiceModel address) {
        this.address = address;
    }

}
