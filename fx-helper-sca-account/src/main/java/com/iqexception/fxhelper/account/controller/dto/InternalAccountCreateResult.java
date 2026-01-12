package com.iqexception.fxhelper.account.controller.dto;

import jakarta.validation.constraints.NotNull;

public class InternalAccountCreateResult {
    @NotNull
    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public InternalAccountCreateResult(Long accountId) {
        this.accountId = accountId;
    }
}
