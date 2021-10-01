package io.trivial.models.views;

import io.trivial.models.entites.Address;

public class UserViewModel extends BaseViewModel {

    private String email;
    private Address address;

    public UserViewModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
