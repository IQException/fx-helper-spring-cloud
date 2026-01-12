package com.iqexception.fxhelper.pay.stub;

import com.iqexception.fxhelper.client.resttemplate.user.api.UserApi;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalVerifyPaySecretRequest;
import com.iqexception.fxhelper.client.resttemplate.user.model.ResponseInternalVerifyPaySecretResult;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserApi userApi;

    private final JsonMapper jsonMapper;

    public UserService(UserApi userApi, JsonMapper jsonMapper) {
        this.userApi = userApi;
        this.jsonMapper = jsonMapper;
    }

    public ResponseInternalVerifyPaySecretResult verifyPaySecret(Long userId, String paySecret) {
        return userApi.internalVerifyPaySecret(new InternalVerifyPaySecretRequest().paySecret(paySecret).userId(userId));
    }

    public boolean verifyPaySecretQuietly(Long userId, String paySecret) {
        try {
            ResponseInternalVerifyPaySecretResult response = verifyPaySecret(userId, paySecret);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getResult();
            } else {
                LOGGER.error("verifyPaySecret failed! userId:{},response:{}",
                        userId, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("verifyPaySecret failed! userId:{}", userId, e);
        }
        return false;
    }

}
