package com.jointrivial.sourcemanager.nordigen.config;

import com.google.gson.*;
import com.jointrivial.sourcemanager.nordigen.api.NordigenSourceLinkAPI;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement json, Type type,
                                                     JsonDeserializationContext context) throws JsonParseException {
                        return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.zzz."));
                    }
                })
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
