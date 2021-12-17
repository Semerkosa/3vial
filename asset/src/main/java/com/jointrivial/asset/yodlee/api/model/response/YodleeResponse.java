package com.jointrivial.asset.yodlee.api.model.response;

public class YodleeResponse {

    private int statusCode;
    private String body;

    public YodleeResponse() {
    }

    public YodleeResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
