package com.jointrivial.sampleapps.yodlee.model.view;

import java.util.List;

public class UserDataViewModel {

    private List<ProviderViewModel> providers;

    public UserDataViewModel() {
    }

    public List<ProviderViewModel> getProviders() {
        return providers;
    }

    public void setProviders(List<ProviderViewModel> providers) {
        this.providers = providers;
    }

}
