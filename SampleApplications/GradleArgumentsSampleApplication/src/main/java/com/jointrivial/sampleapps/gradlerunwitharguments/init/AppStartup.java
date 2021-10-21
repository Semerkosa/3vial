package com.jointrivial.sampleapps.gradlerunwitharguments.init;

import com.jointrivial.sampleapps.gradlerunwitharguments.config.MyProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartup implements CommandLineRunner {

    private final MyProperties myProperties;

    public AppStartup(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Properties:");
        System.out.println("Base url: " + myProperties.getBaseUrl());
        System.out.println("Auth token: " + myProperties.getAuthToken());
    }

}
