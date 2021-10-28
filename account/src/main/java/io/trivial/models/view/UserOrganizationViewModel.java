package io.trivial.models.view;

import java.util.List;

public class UserOrganizationViewModel extends BaseViewModel {

    private List<KeyOrganizationViewModel> keysOrganization;

    public UserOrganizationViewModel() {
    }

	public List<KeyOrganizationViewModel> getKeysOrganization() {
		return keysOrganization;
	}

	public void setKeysOrganization(List<KeyOrganizationViewModel> keysOrganization) {
		this.keysOrganization = keysOrganization;
	}
    
}
