package com.iqexception.fxhelper.pay.controller.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class Acct2wxRequest {
    @NotNull
    private Long accountId;
    @NotNull
    private String openId;
    @NotNull
    private BigDecimal amount;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
