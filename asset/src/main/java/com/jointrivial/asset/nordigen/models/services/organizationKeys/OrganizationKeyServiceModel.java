package com.jointrivial.asset.nordigen.models.services.organizationKeys;

import com.google.gson.annotations.Expose;

public class OrganizationKeyServiceModel {

    @Expose
    private String organizationName;
    @Expose
    private String organizationKey;

    public OrganizationKeyServiceModel() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public OrganizationKeyServiceModel setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public String getOrganizationKey() {
        return organizationKey;
    }

    public OrganizationKeyServiceModel setOrganizationKey(String organizationKey) {
        this.organizationKey = organizationKey;
        return this;
    }
}
