package com.jointrivial.sourcemanager.yodlee.model.deserializer;

import com.google.gson.annotations.Expose;

public class UserDetailsDeserializeModel {

    @Expose
    private String id;

    @Expose
    private String email;

    public UserDetailsDeserializeModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
