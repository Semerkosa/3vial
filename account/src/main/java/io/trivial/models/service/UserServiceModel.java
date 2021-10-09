package io.trivial.models.service;

import java.util.List;

public class UserServiceModel extends BaseServiceModel {

    private String email;
    private String password;
    private AddressServiceModel address;
    private List<KeyOrganizationServiceModel> keysOrganization;

    public UserServiceModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressServiceModel getAddress() {
        return address;
    }

    public void setAddress(AddressServiceModel address) {
        this.address = address;
    }

	public List<KeyOrganizationServiceModel> getKeysOrganization() {
		return keysOrganization;
	}

	public void setKeysOrganization(List<KeyOrganizationServiceModel> keysOrganization) {
		this.keysOrganization = keysOrganization;
	}
    
}
