package com.iqexception.fxhelper.shop.controller.dto;

import jakarta.validation.constraints.NotNull;

public class InternalGetSerialNoResult {
    @NotNull
    private String serialNo;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public InternalGetSerialNoResult() {
    }

    public InternalGetSerialNoResult(String serialNo) {
        this.serialNo = serialNo;
    }
}
