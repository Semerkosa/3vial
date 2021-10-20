package com.jointrivial.sampleapps.yodlee.model.beans;

import com.google.gson.annotations.Expose;

// This class is used to serialize the provider array data from Yodlee's JSON response

public class ProvidersArray {

    @Expose
    private Provider[] provider;

    public ProvidersArray() {
    }

    public Provider[] getProvider() {
        return provider;
    }

    public void setProvider(Provider[] provider) {
        this.provider = provider;
    }
}
