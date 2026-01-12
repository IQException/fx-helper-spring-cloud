package com.iqexception.fxhelper.shop.stub;

import com.iqexception.fxhelper.client.resttemplate.user.api.UserApi;
import com.iqexception.fxhelper.client.resttemplate.user.model.BaseResponse;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalChangePaySecretRequest;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final UserApi userApi;

    private final JsonMapper jsonMapper;

    public UserService(UserApi userApi, JsonMapper jsonMapper) {
        this.userApi = userApi;
        this.jsonMapper = jsonMapper;
    }

    public boolean updatePaySecretQuietly(Long userId, String paySecret) {

        try {
            BaseResponse response = changePaySecret(userId, paySecret);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return true;
            } else {
                LOGGER.error("update pay secret failed! userId:{},response:{}", userId, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("update pay secret failed! userId: {}", userId, e);
        }
        return false;
    }

    public BaseResponse changePaySecret(Long userId, String paySecret) {
        return userApi.internalChangePaySecret(
                new InternalChangePaySecretRequest().userId(userId).paySecret(paySecret));
    }
}
