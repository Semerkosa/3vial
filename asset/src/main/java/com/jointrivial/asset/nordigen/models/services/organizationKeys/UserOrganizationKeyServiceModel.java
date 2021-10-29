package com.jointrivial.asset.nordigen.models.services.organizationKeys;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserOrganizationKeyServiceModel {

    @Expose
    private List<OrganizationKeyServiceModel> organizationKeys;

    public UserOrganizationKeyServiceModel() {
    }

    public List<OrganizationKeyServiceModel> getOrganizationKeys() {
        return organizationKeys;
    }

    public UserOrganizationKeyServiceModel setOrganizationKeys(List<OrganizationKeyServiceModel> organizationKeys) {
        this.organizationKeys = organizationKeys;
        return this;
    }
}
