package com.iqexception.fxhelper.order.stub;

import com.iqexception.fxhelper.client.resttemplate.shop.api.ShopApi;
import com.iqexception.fxhelper.client.resttemplate.shop.model.*;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ShopService {

    private final Logger LOGGER = LoggerFactory.getLogger(ShopService.class);

    private final ShopApi shopApi;

    private final JsonMapper jsonMapper;

    public ShopService(ShopApi shopApi, JsonMapper jsonMapper) {
        this.shopApi = shopApi;
        this.jsonMapper = jsonMapper;
    }

    public ResponseGetShopDetailInfoResult getShop(Long shopId) {
        return shopApi.internalGetDetailInfo(new InternalGetDetailInfoRequest().shopId(shopId));
    }

    public GetShopDetailInfoResult getShopQuietly(Long shopId) {
        try {
            ResponseGetShopDetailInfoResult response = getShop(shopId);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult();
            } else {
                LOGGER.error("get shop failed! shopId:{},response:{}", shopId, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("get shop error! shopId:{}", shopId, e);
        }
        return null;
    }


    public String getSerialNoQuietly(Long shopId, String serialNo) {
        try {
            ResponseInternalGetSerialNoResult response = getSerialNo(shopId, serialNo);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getSerialNo();
            } else {
                LOGGER.error("get serialno failed! shopId:{},serialno:{},response:{}", shopId, serialNo, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("get serialno failed! shopId:{},serialno:{}", shopId, serialNo, e);
        }
        return null;
    }

    public ResponseInternalGetSerialNoResult getSerialNo(Long shopId, String serialNo) {
        return shopApi.internalGetSerialNo(new InternalGetSerialNoRequest().shopId(shopId).serialNo(serialNo));
    }
}
