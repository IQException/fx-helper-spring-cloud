package com.iqexception.fxhelper.order.controller.dto;

import jakarta.validation.constraints.NotNull;

public class OrderCreateResult {

    @NotNull
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderCreateResult(Long orderId) {
        this.orderId = orderId;
    }
}
