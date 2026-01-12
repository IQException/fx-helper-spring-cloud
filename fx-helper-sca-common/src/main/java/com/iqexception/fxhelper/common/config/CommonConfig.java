package com.iqexception.fxhelper.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({HttpConverterConfig.class, RestTemplateConfig.class, ValidationConfig.class,
        MessageSourceConfig.class, I18nConfig.class, JsonConfig.class,
        JooqConfig.class, RmqConfig.class, RedisConfig.class, ObservationConfig.class})
public class CommonConfig {
}
