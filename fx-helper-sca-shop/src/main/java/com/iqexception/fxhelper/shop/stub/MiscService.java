package com.iqexception.fxhelper.shop.stub;

import com.iqexception.fxhelper.client.resttemplate.misc.api.MiscApi;
import com.iqexception.fxhelper.client.resttemplate.misc.model.ResponseGetAccessTokenResult;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

@Component
public class MiscService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final MiscApi miscApi;

    private final JsonMapper jsonMapper;

    public MiscService(MiscApi miscApi, JsonMapper jsonMapper) {
        this.miscApi = miscApi;
        this.jsonMapper = jsonMapper;
    }

    public String getAccessToken() {

        try {
            ResponseGetAccessTokenResult response = miscApi.getAccessToken();
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getAccessToken();
            } else {
                LOGGER.error("get access token failed! response:{}", jsonMapper.serialize(response));
            }
        } catch (RestClientException e) {
            LOGGER.error("get access token failed!", e);
        }

        return null;
    }

}
