package com.iqexception.fxhelper.agg.config;

import com.google.common.collect.Lists;
import com.iqexception.fxhelper.common.advice.InjectMDCFields;
import com.iqexception.fxhelper.common.config.AggServiceConfig;
import com.iqexception.fxhelper.common.constant.CommonConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AggServiceConfig.class)
public class AppConfig {

    @Bean
    public InjectMDCFields injectMDCFromRequestFields() {
        return new InjectMDCFields(Lists.newArrayList(Pair.of("shopId", CommonConstants.MDC_SHOP_ID)));
    }
}
