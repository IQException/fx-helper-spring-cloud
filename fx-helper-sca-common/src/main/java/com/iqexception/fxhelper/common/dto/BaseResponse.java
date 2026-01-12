package com.iqexception.fxhelper.common.dto;


import jakarta.validation.constraints.NotNull;

public class BaseResponse implements HasResponseStatus {

    @NotNull
    private ResponseStatus status;

    public BaseResponse() {
    }

    public BaseResponse(ResponseStatus status) {
        this.status = status;
    }

    @Override
    public ResponseStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
