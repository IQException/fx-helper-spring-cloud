package com.iqexception.fxhelper.shop.config;

import com.google.common.collect.Lists;
import com.iqexception.fxhelper.common.advice.InjectMDCFields;
import com.iqexception.fxhelper.common.config.*;
import com.iqexception.fxhelper.common.constant.CommonConstants;
import io.lettuce.core.resource.ClientResources;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;

@Configuration
@Import({CommonConfig.class})
public class AppConfig {
    @Bean
    public InjectMDCFields injectMDCFromRequestFields() {
        return new InjectMDCFields(Lists.newArrayList(Pair.of("shopId", CommonConstants.MDC_SHOP_ID)));
    }
}
