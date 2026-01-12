package com.iqexception.fxhelper.pay.config;

import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.pay.stub.UserService;
import com.iqexception.fxhelper.pay.support.PayVerifyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
@Configuration
public class FilterBeanConfig {

    @Bean
    public FilterRegistrationBean<PayVerifyFilter> payVerifyFilter(MessageSource messageSource, JsonMapper jsonMapper, UserService userService) {
        FilterRegistrationBean<PayVerifyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new PayVerifyFilter(messageSource, jsonMapper, userService));
        // 提现需要校验支付密码
        registrationBean.addUrlPatterns("/withdraw");
        // 在session filter后面
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);

        return registrationBean;
    }
}
