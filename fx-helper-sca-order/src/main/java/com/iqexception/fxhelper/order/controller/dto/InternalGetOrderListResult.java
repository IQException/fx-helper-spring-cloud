package com.iqexception.fxhelper.order.controller.dto;

import java.util.List;

public class InternalGetOrderListResult {
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public InternalGetOrderListResult() {
    }

    public InternalGetOrderListResult(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
