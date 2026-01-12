package com.iqexception.fxhelper.user.controller.dto;

import jakarta.validation.constraints.NotNull;

public class InternalVerifyPaySecretResult {
    @NotNull
    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
