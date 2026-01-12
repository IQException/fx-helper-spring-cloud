package com.iqexception.fxhelper.order.controller.dto;

import jakarta.validation.constraints.NotNull;

public class InternalGetOrderCountResult {

    @NotNull
    private Integer count;

    public InternalGetOrderCountResult() {
    }

    public InternalGetOrderCountResult(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
