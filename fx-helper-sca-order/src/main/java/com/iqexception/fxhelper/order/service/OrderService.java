package com.iqexception.fxhelper.order.service;

import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.order.controller.dto.*;

public interface OrderService {
    Response<OrderCreateResult> create(Request<OrderCreateParam> request);

    Response<OrderPayResult> pay(Request<OrderPayParam> request);

    Response<InternalGetOrderListResult> internalGetOrderList(InternalGetOrderListRequest request);

    Response<InternalGetOrderCountResult> internalGetOrderCount(InternalGetOrderCountRequest request);

    Response<InternalGetOrderTotalAmountResult> internalGetOrderTotalAmount(InternalGetOrderTotalAmountRequest request);
}
