package com.jointrivial.sourcemanager.nordigen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "arguments.source-manager")
public class ApplicationProperties {

    private String baseUrl;
    private String accessToken;

    public String getBaseUrl() {
        return baseUrl;
    }

    public ApplicationProperties setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public ApplicationProperties setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }


}
