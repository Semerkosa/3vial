package io.trivial.models.service;

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
