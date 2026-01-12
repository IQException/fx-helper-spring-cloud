package com.iqexception.fxhelper.pay.stub;

import com.iqexception.fxhelper.client.resttemplate.shop.api.ShopApi;
import com.iqexception.fxhelper.client.resttemplate.shop.model.InternalGetShopListRequest;
import com.iqexception.fxhelper.client.resttemplate.shop.model.InternalGetUserShopListRequest;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ResponseGetShopListResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ShopDetail;
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

    public ResponseGetShopListResult getShopList(Long userId) {

        return shopApi.internalGetUserShopList(new InternalGetUserShopListRequest().userId(userId));
    }

    public List<ShopDetail> getShopListQuietly(Long userId) {

        try {
            ResponseGetShopListResult response = getShopList(userId);
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
