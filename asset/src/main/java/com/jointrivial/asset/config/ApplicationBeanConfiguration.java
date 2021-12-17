package com.jointrivial.asset.config;

import com.google.gson.*;
import com.jointrivial.asset.nordigen.api.NordigenAccountInfoAPI;
import com.jointrivial.asset.yodlee.api.YodleeApi;
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

    @Bean
    public YodleeApi yodleeApi() {
        return new YodleeApi();
    }
}
