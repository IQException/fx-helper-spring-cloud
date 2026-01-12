package com.iqexception.fxhelper.user.stub;

import com.iqexception.fxhelper.client.resttemplate.account.api.AccountApi;
import com.iqexception.fxhelper.client.resttemplate.account.model.*;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final AccountApi accountApi;

    private final JsonMapper jsonMapper;

    public AccountService(AccountApi accountApi, JsonMapper jsonMapper) {
        this.accountApi = accountApi;
        this.jsonMapper = jsonMapper;
    }

    public boolean createAccountQuietly(Long userId) {
        try {
            ResponseInternalAccountCreateResult response = internalCreate(userId);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return true;
            } else {
                LOGGER.error("create account failed! userId:{},response:{}", userId, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("create account failed! userId:{}", userId, e);
        }
        return false;
    }

    public ResponseInternalAccountCreateResult internalCreate(Long userId) {
        return accountApi.internalCreate(new InternalCreateRequest().userId(userId));

    }

    public ResponseInternalGetAccountResult getAccount(Long userId) {
        return accountApi.internalGet(new InternalGetAccountRequest().userId(userId));
    }

    public InternalGetAccountResult getAccountQuietly(Long userId) {
        try {
            ResponseInternalGetAccountResult response = getAccount(userId);
            if(ResponseUtil.isSuccess(response.getStatus().getErrorCode())){
                return getAccount(userId).getResult();
            }else{
                LOGGER.error("get account failed! userId:{},response:{}", userId, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("internalQuery error! userId:{}", userId, e);
        }
        return null;
    }

}
