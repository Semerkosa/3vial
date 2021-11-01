package com.jointrivial.asset.nordigen.models.services.keysOrganization;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserKeyOrganizationServiceModel {

    @Expose
    private List<KeyOrganizationServiceModel> keysOrganization;

    public UserKeyOrganizationServiceModel() {
    }

    public List<KeyOrganizationServiceModel> getKeysOrganization() {
        return keysOrganization;
    }

    public UserKeyOrganizationServiceModel setKeysOrganization(List<KeyOrganizationServiceModel> keysOrganization) {
        this.keysOrganization = keysOrganization;
        return this;
    }
}
