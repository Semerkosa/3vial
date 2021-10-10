package io.trivial.models.view;

import io.trivial.models.entites.BaseEntity;

public class KeyOrganizationViewModel extends BaseEntity {

    private String organizationName;
    private String organizationKey;

    public KeyOrganizationViewModel() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationKey() {
		return organizationKey;
	}

	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}
}
