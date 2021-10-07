package io.trivial.models.binding;

public class UserRegisterBindingModel {

    private String email;
    private String password;
    private AddressBindingModel address;

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

    public AddressBindingModel getAddress() {
        return address;
    }

    public void setAddress(AddressBindingModel address) {
        this.address = address;
    }

}
