package com.jointrivial.asset.nordigen.models.services.organizationKeys;

import com.google.gson.annotations.Expose;

public class KeyOrganizationServiceModel {

    @Expose
    private String organizationName;
    @Expose
    private String organizationKey;

    public KeyOrganizationServiceModel() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public KeyOrganizationServiceModel setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public String getOrganizationKey() {
        return organizationKey;
    }

    public KeyOrganizationServiceModel setOrganizationKey(String organizationKey) {
        this.organizationKey = organizationKey;
        return this;
    }
}
