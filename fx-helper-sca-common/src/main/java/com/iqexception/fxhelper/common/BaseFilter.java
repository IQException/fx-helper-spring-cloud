package com.iqexception.fxhelper.common;

import com.iqexception.fxhelper.common.dto.ResponseStatus;
import com.iqexception.fxhelper.common.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

public class BaseFilter {

    protected MessageSource messageSource;

    protected JsonMapper jsonMapper;

    protected Logger LOG = LoggerFactory.getLogger(getClass());

    public BaseFilter(MessageSource messageSource, JsonMapper jsonMapper) {
        this.messageSource = messageSource;
        this.jsonMapper = jsonMapper;
    }

    public BaseFilter() {
    }

    protected ResponseStatus buildRespStatus(int errorCode) {
        ResponseStatus status = new ResponseStatus();
        status.setErrorCode(String.valueOf(errorCode));
        status.setErrorMessage(MessageUtil.message(errorCode, messageSource));
        return status;
    }
}
