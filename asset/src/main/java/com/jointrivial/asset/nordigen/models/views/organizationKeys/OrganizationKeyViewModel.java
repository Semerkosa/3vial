package com.jointrivial.asset.nordigen.models.views.organizationKeys;

public class OrganizationKeyViewModel {

    private String organizationName;
    private String organizationKey;

    public OrganizationKeyViewModel() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public OrganizationKeyViewModel setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public String getOrganizationKey() {
        return organizationKey;
    }

    public OrganizationKeyViewModel setOrganizationKey(String organizationKey) {
        this.organizationKey = organizationKey;
        return this;
    }
}
