package com.iqexception.fxhelper.order.controller.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class InternalGetOrderTotalAmountResult {
    @NotNull
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public InternalGetOrderTotalAmountResult() {
    }

    public InternalGetOrderTotalAmountResult(BigDecimal amount) {
        this.amount = amount;
    }
}
