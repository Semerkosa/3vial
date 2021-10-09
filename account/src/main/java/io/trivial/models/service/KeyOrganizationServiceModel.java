package io.trivial.models.service;

import io.trivial.models.entites.BaseEntity;

public class KeyOrganizationServiceModel extends BaseEntity {

    private String name;
    private String organizationKey;

    public KeyOrganizationServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getOrganizationKey() {
		return organizationKey;
	}

	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}
    
}
