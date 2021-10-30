package com.jointrivial.asset.nordigen.models.views.organizationKeys;

import java.util.List;

public class UserOrganizationKeyViewModel {

    private List<OrganizationKeyViewModel> keysOrganization;

    public UserOrganizationKeyViewModel() {
    }

    public List<OrganizationKeyViewModel> getKeysOrganization() {
        return keysOrganization;
    }

    public UserOrganizationKeyViewModel setKeysOrganization(List<OrganizationKeyViewModel> keysOrganization) {
        this.keysOrganization = keysOrganization;
        return this;
    }
}
