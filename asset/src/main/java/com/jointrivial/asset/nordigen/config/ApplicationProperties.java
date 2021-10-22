package com.jointrivial.asset.nordigen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
public class ApplicationProperties {

    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public ApplicationProperties setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
