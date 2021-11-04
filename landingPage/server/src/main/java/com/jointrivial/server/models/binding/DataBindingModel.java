package com.jointrivial.server.models.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class DataBindingModel {

    private String email;

    public DataBindingModel() {
    }

    public DataBindingModel(String email) {
        this.email = email;
    }

    @NotEmpty
    @Email(regexp = "^(.+)@(\\S+)$")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
