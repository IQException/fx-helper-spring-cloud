package com.iqexception.fxhelper.common.filter;

import com.iqexception.fxhelper.common.BaseFilter;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.TLVarManager;
import com.iqexception.fxhelper.common.constant.CommonConstants;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class SessionFilter extends BaseFilter implements Filter {

    public SessionFilter(MessageSource messageSource, JsonMapper jsonMapper) {
        super(messageSource, jsonMapper);
    }

    public SessionFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String userId = req.getHeader(CommonConstants.HEADER_USER_ID);
        String openId = req.getHeader(CommonConstants.HEADER_OPEN_ID);

        if (StringUtils.isNotBlank(userId)) {
            TLVarManager.setUserId(Long.valueOf(userId));
        }
        if (StringUtils.isNotBlank(openId)) {
            TLVarManager.setOpenId(openId);
        }

        try {
            chain.doFilter(request, response);
        } finally {
            TLVarManager.removeUserId();
            TLVarManager.removeOpenId();
        }

    }
}
