package com.iqexception.fxhelper.order.stub;

import com.iqexception.fxhelper.client.resttemplate.user.api.UserApi;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalGetUserRequest;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalGetUserResult;
import com.iqexception.fxhelper.client.resttemplate.user.model.ResponseInternalGetUserResult;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

@Component
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserApi userApi;

    private final JsonMapper jsonMapper;

    public UserService(UserApi userApi, JsonMapper jsonMapper) {
        this.userApi = userApi;
        this.jsonMapper = jsonMapper;
    }

    public InternalGetUserResult getUserQuietly(Long userId) {
        try {
            ResponseInternalGetUserResult response = getUser(userId);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult();
            } else {
                LOGGER.error("get user failed! userId:{},response:{}", userId, jsonMapper.serialize(response));
            }
        } catch (RestClientException e) {
            LOGGER.error("get user failed! userId:{}", userId, e);
        }
        return null;
    }

    public ResponseInternalGetUserResult getUser(Long userId) {
        return userApi.internalGet(new InternalGetUserRequest().userId(userId));
    }
}
