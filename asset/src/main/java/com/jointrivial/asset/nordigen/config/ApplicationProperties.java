package com.jointrivial.asset.nordigen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "arguments")
public class ApplicationProperties {

    private String baseUrl;
    private String secretId;
    private String secretKey;

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
}
