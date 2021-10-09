package io.trivial.models.view;

import io.trivial.models.entites.BaseEntity;

public class KeyOrganizationViewModel extends BaseEntity {

    private String name;
    private String organizationKey;

    public KeyOrganizationViewModel() {
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
