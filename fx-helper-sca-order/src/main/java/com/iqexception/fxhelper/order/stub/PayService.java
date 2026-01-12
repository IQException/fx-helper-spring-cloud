package com.iqexception.fxhelper.order.stub;

import com.iqexception.fxhelper.client.resttemplate.pay.api.PayApi;
import com.iqexception.fxhelper.client.resttemplate.pay.model.Acct2wxRequest;
import com.iqexception.fxhelper.client.resttemplate.pay.model.ResponseInternalAcct2wxResult;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;

@Component
public class PayService {

    private final Logger LOGGER = LoggerFactory.getLogger(PayService.class);

    private final PayApi payApi;
    private final JsonMapper jsonMapper;

    public PayService(PayApi payApi, JsonMapper jsonMapper) {
        this.payApi = payApi;
        this.jsonMapper = jsonMapper;
    }

    public ResponseInternalAcct2wxResult acct2wx(Long accountId, String openId, BigDecimal amount) {
        return payApi.acct2wx(new Acct2wxRequest().accountId(accountId).openId(openId).amount(amount));
    }

    public Long acct2wxQuietly(Long accountId, String openId, BigDecimal amount) {
        try {
            ResponseInternalAcct2wxResult response = acct2wx(accountId, openId, amount);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getPayId();
            } else {
                LOGGER.error("acct2wx failed! accountId:{}, openId:{}, amount:{}, response:{}",
                        accountId, openId, amount, jsonMapper.serialize(response));
            }
        } catch (RestClientException e) {
            LOGGER.error("acct2wx error! accountId:{}, openId:{}, amount:{}", accountId, openId, amount, e);
        }
        return null;
    }
}
