package io.trivial.models.service;

//import com.google.gson.annotations.Expose;

import java.util.List;

public class UserKeyOrganizationServiceModel {

//    @Expose
    private List<KeyOrganizationServiceModel> keysOrganization;

    public UserKeyOrganizationServiceModel() {
    }

    public List<KeyOrganizationServiceModel> getKeysOrganization() {
        return keysOrganization;
    }

    public void setKeysOrganization(List<KeyOrganizationServiceModel> keysOrganization) {
        this.keysOrganization = keysOrganization;
    }
}
