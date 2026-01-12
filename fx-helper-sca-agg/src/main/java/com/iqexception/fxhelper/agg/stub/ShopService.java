package com.iqexception.fxhelper.agg.stub;

import com.iqexception.fxhelper.client.resttemplate.shop.api.ShopApi;
import com.iqexception.fxhelper.client.resttemplate.shop.model.*;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

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

    public ResponseGetShopListResult getShopList(List<Long> shopIds) {

        return shopApi.internalGetShopList(new InternalGetShopListRequest().shopIds(shopIds));
    }

    public List<ShopDetail> getShopListQuietly(List<Long> shopIds) {

        try {
            ResponseGetShopListResult response = getShopList(shopIds);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getShopList() == null ?
                        Collections.emptyList()
                        : response.getResult().getShopList();
            } else {
                LOGGER.error("get shop list failed! response:{}", jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyList();

    }
}
