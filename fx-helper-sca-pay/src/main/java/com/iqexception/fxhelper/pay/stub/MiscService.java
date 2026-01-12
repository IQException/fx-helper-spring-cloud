package com.iqexception.fxhelper.pay.stub;

import com.iqexception.fxhelper.client.resttemplate.misc.api.MiscApi;
import com.iqexception.fxhelper.client.resttemplate.misc.model.BaseResponse;
import com.iqexception.fxhelper.client.resttemplate.misc.model.SendWxMessageRequest;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MiscService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final MiscApi miscApi;

    private final JsonMapper jsonMapper;

    public MiscService(MiscApi miscApi, JsonMapper jsonMapper) {
        this.miscApi = miscApi;
        this.jsonMapper = jsonMapper;
    }

    public BaseResponse sendMessage(String templateId, String openId, String page, Object message) {
        return miscApi.sendMessage(new SendWxMessageRequest()
                .templateId(templateId)
                .openId(openId)
                .page(page)
                .data(message));
    }


    public boolean sendMessageQuietly(String templateId, String openId, String page, Object message) {
        try {
            BaseResponse response = sendMessage(templateId, openId, page, message);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return true;
            } else {
                LOGGER.error("send message failed! templateId:{},openId:{},response:{}", templateId, openId, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("send message error! templateId:{},openId:{}", templateId, openId, e);
        }
        return false;
    }

}
