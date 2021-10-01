package io.trivial.models.binding;
import io.trivial.models.entites.Address;

public class UserRegisterBindingModel extends BaseBindingModel {

    private String email;
    private String password;
    private Address address;

    public UserRegisterBindingModel() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
