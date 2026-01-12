package com.iqexception.fxhelper.pay.controller.dto;

import jakarta.validation.constraints.NotNull;

public class InternalAcct2wxResult {
    @NotNull
    private Long payId;

    public InternalAcct2wxResult() {
    }

    public InternalAcct2wxResult(Long payId) {
        this.payId = payId;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
}
