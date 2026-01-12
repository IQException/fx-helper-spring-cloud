package com.iqexception.fxhelper.agg.stub;

import com.iqexception.fxhelper.client.resttemplate.user.api.UserApi;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalGetUserListRequest;
import com.iqexception.fxhelper.client.resttemplate.user.model.ResponseInternalGetUserListResult;
import com.iqexception.fxhelper.client.resttemplate.user.model.UserInfo;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserApi userApi;

    private final JsonMapper jsonMapper;

    public UserService(UserApi userApi, JsonMapper jsonMapper) {
        this.userApi = userApi;
        this.jsonMapper = jsonMapper;
    }

    public ResponseInternalGetUserListResult getUserList(List<Long> userIds) {
        return userApi.internalGetUserList(new InternalGetUserListRequest().userIds(userIds));
    }

    public List<UserInfo> getUserListQuietly(List<Long> userIds) {
        try {
            ResponseInternalGetUserListResult response = getUserList(userIds);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getUserList() == null ?
                        Collections.emptyList() : response.getResult().getUserList();
            } else {
                LOGGER.error("getUserListQuietly error! response:{}", jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("getUserListQuietly error", e);
        }
        return Collections.emptyList();
    }
}
