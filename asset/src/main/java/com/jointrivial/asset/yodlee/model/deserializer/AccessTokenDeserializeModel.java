package com.jointrivial.asset.yodlee.model.deserializer;

import com.google.gson.annotations.Expose;

public class AccessTokenDeserializeModel {

    @Expose
    private TokenDetailsDeserializeModel token;

    public AccessTokenDeserializeModel() {
    }

    public TokenDetailsDeserializeModel getToken() {
        return token;
    }

    public void setToken(TokenDetailsDeserializeModel token) {
        this.token = token;
    }

}
