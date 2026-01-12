package com.iqexception.fxhelper.pay.support;


import com.iqexception.fxhelper.common.BaseFilter;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.TLVarManager;
import com.iqexception.fxhelper.common.constant.ErrorCode;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.pay.stub.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;

import java.io.IOException;

public class PayVerifyFilter extends BaseFilter implements Filter {
    public static final String HEADER_PAY_SECRET = "FX-PAY-SECRET";

    private final UserService userService;

    public PayVerifyFilter(MessageSource messageSource, JsonMapper jsonMapper, UserService userService) {
        super(messageSource, jsonMapper);
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");

        String secret = req.getHeader(HEADER_PAY_SECRET);

        if (StringUtils.isBlank(secret) || !verify(secret)) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatus(buildRespStatus(ErrorCode.PASSWORD_ERROR));
            res.getWriter().write(jsonMapper.serialize(baseResponse));
            res.getWriter().flush();
            LOG.warn("pay secret : {} is incorrect !", secret);
            return;
        }
        chain.doFilter(request, response);
    }

    private boolean verify(String secret) {
        return userService.verifyPaySecretQuietly(TLVarManager.getUserId(), secret);
    }
}
