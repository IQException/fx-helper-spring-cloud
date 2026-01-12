package com.iqexception.fxhelper.common.filter;

import com.iqexception.fxhelper.common.constant.CommonConstants;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MDCFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String userId = req.getHeader(CommonConstants.HEADER_USER_ID);
        if(StringUtils.isNotEmpty(userId)){
            MDC.put(CommonConstants.MDC_USER_ID, userId);
        }

        String openId = req.getHeader(CommonConstants.HEADER_OPEN_ID);
        if(StringUtils.isNotEmpty(openId)){
            MDC.put(CommonConstants.MDC_OPEN_ID, openId);
        }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.clear();
        }


    }
}
