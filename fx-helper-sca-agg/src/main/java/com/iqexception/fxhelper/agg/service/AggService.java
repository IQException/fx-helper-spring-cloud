package com.iqexception.fxhelper.agg.service;


import com.iqexception.fxhelper.agg.controller.dto.*;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;

public interface AggService {
    Response<ShopOrderListResult> listShopOrders(Request<ShopOrderListParam> request);

    Response<GetShopResult> getShop(Request<GetShopParam> request);

    Response<UserOrderListResult> listUserOrders(Request<UserOrderListParam> request);
}
