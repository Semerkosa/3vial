package io.trivial.models.binding;
import io.trivial.models.entites.Address;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import static io.trivial.constants.RegexConstants.PASSWORD_REGEX;
import static io.trivial.constants.RegexConstants.PASSWORD_REGEX_ERROR;

public class UserRegisterBindingModel {

    private String email;
    private String password;
    private AddressBindingModel address;

    public UserRegisterBindingModel() {
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = PASSWORD_REGEX, message = PASSWORD_REGEX_ERROR)
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
