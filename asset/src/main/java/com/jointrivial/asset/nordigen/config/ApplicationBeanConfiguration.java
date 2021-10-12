package com.jointrivial.asset.nordigen.config;

import com.google.gson.*;
import com.jointrivial.asset.nordigen.api.NordigenAccountInfoAPI;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

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
    public NordigenAccountInfoAPI nordigenAccountInfoAPI() {
        return new NordigenAccountInfoAPI();
    }

}
