package com.iqexception.fxhelper.order.stub;

import com.iqexception.fxhelper.client.resttemplate.account.api.AccountApi;
import com.iqexception.fxhelper.client.resttemplate.account.model.InternalGetAccountRequest;
import com.iqexception.fxhelper.client.resttemplate.account.model.InternalGetAccountResult;
import com.iqexception.fxhelper.client.resttemplate.account.model.ResponseInternalGetAccountResult;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

@Component
public class AccountService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final AccountApi accountApi;

    private final JsonMapper jsonMapper;

    public AccountService(AccountApi accountApi, JsonMapper jsonMapper) {
        this.accountApi = accountApi;
        this.jsonMapper = jsonMapper;
    }


    public ResponseInternalGetAccountResult getAccount(Long userId) {
        return accountApi.internalGet(new InternalGetAccountRequest().userId(userId));
    }

    public InternalGetAccountResult getAccountQuietly(Long userId) {
        try {
            ResponseInternalGetAccountResult response = getAccount(userId);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult();
            } else {
                LOGGER.error("get account failed! userId:{},response:{}", userId, jsonMapper.serialize(response));
            }
        } catch (RestClientException e) {
            LOGGER.error("get account failed! userId:{}", userId, e);
        }
        return null;
    }
}
