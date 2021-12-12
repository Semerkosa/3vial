package com.jointrivial.sourcemanager.nordigen.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public NordigenSourceLinkAPI nordigenAccountInfoAPI() {
        return new NordigenSourceLinkAPI();
    }

}
