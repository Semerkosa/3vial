package com.jointrivial.asset.nordigen.models.services.organizationKeys;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserKeyOrganizationServiceModel {

    @Expose
    private List<KeyOrganizationServiceModel> keysOrganization;

    public UserKeyOrganizationServiceModel() {
    }

    public List<KeyOrganizationServiceModel> getOrganizationKeys() {
        return keysOrganization;
    }

    public UserKeyOrganizationServiceModel setOrganizationKeys(List<KeyOrganizationServiceModel> organizationKeys) {
        this.keysOrganization = organizationKeys;
        return this;
    }
}
