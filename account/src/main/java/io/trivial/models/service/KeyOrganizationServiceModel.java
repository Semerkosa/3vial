package io.trivial.models.service;

import io.trivial.models.entites.BaseEntity;

public class KeyOrganizationServiceModel extends BaseEntity {

    private String organizationName;
    private String organizationKey;

    public KeyOrganizationServiceModel() {
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
