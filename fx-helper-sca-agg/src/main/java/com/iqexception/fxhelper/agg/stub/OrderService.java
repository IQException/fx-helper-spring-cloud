package com.iqexception.fxhelper.agg.stub;

import com.iqexception.fxhelper.client.resttemplate.order.api.OrderApi;
import com.iqexception.fxhelper.client.resttemplate.order.model.*;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;

@Component
public class OrderService {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    private final JsonMapper jsonMapper;

    private final OrderApi orderApi;


    public OrderService(JsonMapper jsonMapper, OrderApi orderApi) {
        this.jsonMapper = jsonMapper;
        this.orderApi = orderApi;
    }


    public ResponseInternalGetOrderListResult getOrderList(Long shopId, Long userId, Integer status,
                                                           LocalDateTime from, LocalDateTime to,
                                                           Integer offset, Integer limit) {
        InternalGetOrderListRequest request = new InternalGetOrderListRequest()
                .shopId(shopId).userId(userId).status(status)
                .offset(offset).limit(limit);

        if (from != null) {
            request.from(from.atOffset(OffsetDateTime.now().getOffset()));

        }
        if (to != null) {
            request.to(to.atOffset(OffsetDateTime.now().getOffset()));
        }


        return orderApi.internalGetOrderList(request);
    }

    public List<OrderDetail> getOrderListQuietly(Long shopId, Long userId, Integer status,
                                                 LocalDateTime from, LocalDateTime to,
                                                 Integer offset, Integer limit) {
        try {
            ResponseInternalGetOrderListResult response = getOrderList(shopId, userId, status, from, to, offset, limit);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getOrderDetails() == null ?
                        Collections.emptyList() : response.getResult().getOrderDetails();
            } else {
                LOGGER.error("get order list failed! shopId:{},userId:{},status:{},from:{},to:{},offset:{},limit:{},response:{}",
                        shopId, userId, status, from, to, offset, limit, jsonMapper.serialize(response));
            }
        } catch (RestClientException e) {
            LOGGER.error("get order list failed! shopId:{},userId:{},status:{},from:{},to:{},offset:{},limit:{}",
                    shopId, userId, status, from, to, offset, limit, e);
        }
        return Collections.emptyList();
    }

    public ResponseInternalGetOrderCountResult getOrderCount(Long shopId, int status) {

        return orderApi.internalGetOrderCount(new InternalGetOrderCountRequest().shopId(shopId).status(status));

    }

    public int getOrderCountQuietly(Long shopId, int status) {

        try {
            ResponseInternalGetOrderCountResult response = getOrderCount(shopId, status);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getCount();
            } else {
                LOGGER.error("get order count failed! shopId:{},status:{},response:{}",
                        shopId, status, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("get order count failed! shopId:{},status:{}", shopId, status);
        }

        return 0;
    }

    public ResponseInternalGetOrderTotalAmountResult getOrderTotalAmount(Long shopId, int status) {
        return orderApi.internalGetTotalAmount(new InternalGetOrderTotalAmountRequest().shopId(shopId).status(status));
    }

    public BigDecimal getOrderTotalAmountQuietly(Long shopId, int status) {

        try {
            ResponseInternalGetOrderTotalAmountResult response = getOrderTotalAmount(shopId, status);
            if (ResponseUtil.isSuccess(response.getStatus().getErrorCode())) {
                return response.getResult().getAmount();
            } else {
                LOGGER.error("get order total amount failed! shopId:{},status:{},response:{}",
                        shopId, status, jsonMapper.serialize(response));
            }
        } catch (Exception e) {
            LOGGER.error("get order total amount failed! shopId:{},status:{}", shopId, status);
        }
        return BigDecimal.ZERO;
    }
}
