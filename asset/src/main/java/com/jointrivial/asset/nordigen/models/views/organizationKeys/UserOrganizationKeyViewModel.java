package com.jointrivial.asset.nordigen.models.views.organizationKeys;

import java.util.List;

public class UserOrganizationKeyViewModel {

    private List<OrganizationKeyViewModel> organizationKeys;

    public UserOrganizationKeyViewModel() {
    }

    public List<OrganizationKeyViewModel> getOrganizationKeys() {
        return organizationKeys;
    }

    public UserOrganizationKeyViewModel setOrganizationKeys(List<OrganizationKeyViewModel> organizationKeys) {
        this.organizationKeys = organizationKeys;
        return this;
    }
}
