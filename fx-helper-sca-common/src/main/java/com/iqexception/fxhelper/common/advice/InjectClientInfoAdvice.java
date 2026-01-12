package com.iqexception.fxhelper.common.advice;

import com.iqexception.fxhelper.common.ClientInfo;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.TLVarManager;
import com.iqexception.fxhelper.common.dto.HasMobileRequestHead;
import com.iqexception.fxhelper.common.dto.MobileRequestHead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@ControllerAdvice
public class InjectClientInfoAdvice implements RequestBodyAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(InjectClientInfoAdvice.class);

    private final JsonMapper jsonMapper;

    public InjectClientInfoAdvice(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

        Class[] paramTypes = methodParameter.getMethod().getParameterTypes();
        return paramTypes.length == 1 && HasMobileRequestHead.class.isAssignableFrom(paramTypes[0]);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {


        // 将head放入ThreadLocal中
        MobileRequestHead head = ((HasMobileRequestHead) body).getHead();
        TLVarManager.setClientInfo(buildClientInfo(head));

        LOG.info("request body:{}", jsonMapper.serialize(body));

        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    private ClientInfo buildClientInfo(MobileRequestHead head) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setBrand(head.getBrand());
        clientInfo.setIp(head.getIp());
        clientInfo.setMac(head.getMac());
        clientInfo.setModel(head.getModel());
        clientInfo.setSystem(head.getSystem());
        clientInfo.setDeviceId(head.getDeviceId());
        clientInfo.setPlatform(head.getPlatform());
        clientInfo.setLongitude(head.getLongitude());
        clientInfo.setLatitude(head.getLatitude());
        clientInfo.setSign(head.getSign());
        return clientInfo;
    }
}
