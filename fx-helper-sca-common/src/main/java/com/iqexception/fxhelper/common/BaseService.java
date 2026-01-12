package com.iqexception.fxhelper.common;

import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.common.dto.ResponseStatus;
import com.iqexception.fxhelper.common.util.MessageUtil;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;

public class BaseService {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected MessageSource messageSource;
    protected JsonMapper jsonMapper;
    protected StringRedisTemplate redisTemplate;
    protected RmqHelper rmqHelper;

    public BaseService(MessageSource messageSource, JsonMapper jsonMapper, StringRedisTemplate redisTemplate) {
        this.messageSource = messageSource;
        this.jsonMapper = jsonMapper;
        this.redisTemplate = redisTemplate;
    }

    public BaseService(MessageSource messageSource, JsonMapper jsonMapper) {
        this.messageSource = messageSource;
        this.jsonMapper = jsonMapper;
    }

    public BaseService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public BaseService(
            MessageSource messageSource,
            JsonMapper jsonMapper,
            StringRedisTemplate redisTemplate,
            RmqHelper rmqHelper) {
        this.messageSource = messageSource;
        this.jsonMapper = jsonMapper;
        this.redisTemplate = redisTemplate;
        this.rmqHelper = rmqHelper;
    }

    public BaseService(MessageSource messageSource, JsonMapper jsonMapper, RmqHelper rmqHelper) {
        this.messageSource = messageSource;
        this.jsonMapper = jsonMapper;
        this.rmqHelper = rmqHelper;
    }

    public ResponseStatus status(int errorCode) {
        ResponseStatus status = new ResponseStatus();
        status.setErrorCode(String.valueOf(errorCode));
        status.setErrorMessage(MessageUtil.message(errorCode, messageSource));
        return status;
    }

    public ResponseStatus status(int errorCode, String errorMessage) {
        ResponseStatus status = new ResponseStatus();
        status.setErrorCode(String.valueOf(errorCode));
        status.setErrorMessage(errorMessage);
        return status;
    }

    public <T> Response<T> response(int errorCode) {
        return ResponseUtil.response(status(errorCode));
    }

    public <T> Response<T> response(ResponseStatus status) {
        return ResponseUtil.response(status);
    }

    public static <T> Response<T> responseOk() {
        return responseOk(null);
    }

    public static <T> Response<T> responseOk(T result) {
        return new Response<>(ResponseUtil.statusOk(), result);
    }


}
