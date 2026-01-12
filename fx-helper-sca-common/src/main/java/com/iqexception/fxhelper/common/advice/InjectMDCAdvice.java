package com.iqexception.fxhelper.common.advice;

import com.iqexception.fxhelper.common.dto.BaseRequest;
import com.iqexception.fxhelper.common.dto.HasMobileRequestHead;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

@ControllerAdvice
public class InjectMDCAdvice implements RequestBodyAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(InjectMDCAdvice.class);
    private final InjectMDCFields injectFields;

    public InjectMDCAdvice(ObjectProvider<InjectMDCFields> injectFields) {
        this.injectFields = injectFields.getIfAvailable();
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (injectFields == null || CollectionUtils.isEmpty(injectFields.getInjectFields())) return false;
        Class<?>[] paramTypes = methodParameter.getMethod().getParameterTypes();
        return paramTypes.length == 1 && BaseRequest.class != paramTypes[0];
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

        Class<?> bodyClass = body.getClass();
        try {
            Object param = null;
            if (HasMobileRequestHead.class.isAssignableFrom(bodyClass)) {
                Field paramField = bodyClass.getField("param");
                paramField.setAccessible(true);
                param = paramField.get(body);
            }
            if (param != null && injectFields != null && injectFields.getInjectFields() != null) {
                Class<?> paramClass = param.getClass();
                for (Pair<String, String> pair : injectFields.getInjectFields()) {
                    Field field = paramClass.getField(pair.getLeft());
                    field.setAccessible(true);
                    MDC.put(pair.getRight(), String.valueOf(field.get(param)));
                    //目前在在出口处统一clear，严谨起见，应该在对称的ResponseBodyAdvice.beforeBodyWrite中clear
                }
            }
        } catch (NoSuchFieldException ignored) {
        } catch (IllegalAccessException e) {
            LOG.error("reflect failed ! class:{}", bodyClass, e);
        }
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
