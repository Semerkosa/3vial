package io.trivial.models.view;

import io.trivial.models.service.AddressServiceModel;

import java.util.List;

public class UserViewModel {

    private String email;
    private AddressServiceModel address;
    private List<KeyOrganizationViewModel> keysOrganization;

    public UserViewModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressServiceModel getAddress() {
        return address;
    }

    public void setAddress(AddressServiceModel address) {
        this.address = address;
    }

	public List<KeyOrganizationViewModel> getKeysOrganization() {
		return keysOrganization;
	}

	public void setKeysOrganization(List<KeyOrganizationViewModel> keysOrganization) {
		this.keysOrganization = keysOrganization;
	}
    
}
