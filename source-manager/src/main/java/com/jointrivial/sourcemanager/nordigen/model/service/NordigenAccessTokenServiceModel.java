package com.jointrivial.sourcemanager.nordigen.model.service;

import com.google.gson.annotations.Expose;

public class NordigenAccessTokenServiceModel {

    @Expose
    private String access;
    @Expose
    private long access_expires;
    @Expose
    private String refresh;
    @Expose
    private long refresh_expires;


    public NordigenAccessTokenServiceModel() {
    }

    public String getAccess() {
        return access;
    }

    public NordigenAccessTokenServiceModel setAccess(String access) {
        this.access = access;
        return this;
    }

    public long getAccess_expires() {
        return access_expires;
    }

    public NordigenAccessTokenServiceModel setAccess_expires(long access_expires) {
        this.access_expires = access_expires;
        return this;
    }

    public String getRefresh() {
        return refresh;
    }

    public NordigenAccessTokenServiceModel setRefresh(String refresh) {
        this.refresh = refresh;
        return this;
    }

    public long getRefresh_expires() {
        return refresh_expires;
    }

    public NordigenAccessTokenServiceModel setRefresh_expires(long refresh_expires) {
        this.refresh_expires = refresh_expires;
        return this;
    }
}
