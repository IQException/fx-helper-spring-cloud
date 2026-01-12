package com.iqexception.fxhelper.account.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class InternalTransferRequest {
    @Positive
    @NotNull
    private Long toAccountId;
    @Positive
    @NotNull
    private Long fromAccountId;
    @Positive
    @NotNull
    private BigDecimal amount;

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public InternalTransferRequest() {
    }

    public InternalTransferRequest(Long toAccountId, BigDecimal amount) {
        this.toAccountId = toAccountId;
        this.amount = amount;
    }
}
