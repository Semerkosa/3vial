package io.trivial.models.view;

import java.util.List;

public class UserKeyOrganizationViewModel {

    private List<KeyOrganizationViewModel> keysOrganization;

    public UserKeyOrganizationViewModel() {
    }

	public List<KeyOrganizationViewModel> getKeysOrganization() {
		return keysOrganization;
	}

	public void setKeysOrganization(List<KeyOrganizationViewModel> keysOrganization) {
		this.keysOrganization = keysOrganization;
	}
    
}
