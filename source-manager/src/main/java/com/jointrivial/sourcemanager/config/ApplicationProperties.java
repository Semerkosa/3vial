package com.jointrivial.sourcemanager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "arguments.source-manager")
public class ApplicationProperties {

    private String baseUrl;
    private String secretId;
    private String secretKey;
    private String yodleeBaseUrl;
    private String yodleeClientId;
    private String yodleeSecret;
    private String yodleeAdminLoginName;

    public String getBaseUrl() {
        return baseUrl;
    }

    public ApplicationProperties setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public String getSecretId() {
        return secretId;
    }

    public ApplicationProperties setSecretId(String secretId) {
        this.secretId = secretId;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public ApplicationProperties setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public String getYodleeBaseUrl() {
        return yodleeBaseUrl;
    }

    public ApplicationProperties setYodleeBaseUrl(String yodleeBaseUrl) {
        this.yodleeBaseUrl = yodleeBaseUrl;
        return this;
    }

    public String getYodleeClientId() {
        return yodleeClientId;
    }

    public ApplicationProperties setYodleeClientId(String yodleeClientId) {
        this.yodleeClientId = yodleeClientId;
        return this;
    }

    public String getYodleeSecret() {
        return yodleeSecret;
    }

    public ApplicationProperties setYodleeSecret(String yodleeSecret) {
        this.yodleeSecret = yodleeSecret;
        return this;
    }

    public String getYodleeAdminLoginName() {
        return yodleeAdminLoginName;
    }

    public ApplicationProperties setYodleeAdminLoginName(String yodleeAdminLoginName) {
        this.yodleeAdminLoginName = yodleeAdminLoginName;
        return this;
    }
}
