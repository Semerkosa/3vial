package com.jointrivial.sourcemanager.yodlee.model.deserializer;

import com.google.gson.annotations.Expose;

public class TokenDetailsDeserializeModel {

    @Expose
    private String accessToken;

    @Expose
    private String issuedAt;

    @Expose
    private int expiresIn;

    public TokenDetailsDeserializeModel() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
