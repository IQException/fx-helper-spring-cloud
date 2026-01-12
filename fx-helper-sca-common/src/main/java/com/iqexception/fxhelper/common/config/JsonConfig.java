package com.iqexception.fxhelper.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iqexception.fxhelper.common.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig {

    @Bean
    public JsonMapper jsonMapper(ObjectMapper objectMapper) {
        return new JsonMapper(objectMapper);
    }
}
