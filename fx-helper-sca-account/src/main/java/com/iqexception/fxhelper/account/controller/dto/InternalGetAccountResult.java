package com.iqexception.fxhelper.account.controller.dto;


import com.iqexception.fxhelper.account.dal.generator.tables.pojos.FxAccount;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class InternalGetAccountResult {


    @NotNull
    private Long accountId;

    @NotNull
    private Long userId;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private Integer status;

    @NotNull
    private OffsetDateTime createdAt;

    @NotNull
    private OffsetDateTime updatedAt;


    public InternalGetAccountResult(FxAccount value) {
        this.accountId = value.getAccountId();
        this.userId = value.getUserId();
        this.balance = value.getBalance();
        this.status = value.getStatus();
        this.createdAt = value.getCreatedAt().atOffset(OffsetDateTime.now().getOffset());
        this.updatedAt = value.getUpdatedAt().atOffset(OffsetDateTime.now().getOffset());
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
