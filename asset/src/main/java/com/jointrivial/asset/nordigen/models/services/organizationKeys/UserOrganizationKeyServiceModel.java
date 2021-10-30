package com.jointrivial.asset.nordigen.models.services.organizationKeys;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserOrganizationKeyServiceModel {

    @Expose
    private List<OrganizationKeyServiceModel> keysOrganization;

    public UserOrganizationKeyServiceModel() {
    }

    public List<OrganizationKeyServiceModel> getOrganizationKeys() {
        return keysOrganization;
    }

    public UserOrganizationKeyServiceModel setOrganizationKeys(List<OrganizationKeyServiceModel> organizationKeys) {
        this.keysOrganization = organizationKeys;
        return this;
    }
}
