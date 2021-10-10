package com.jointrivial.Reference.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
