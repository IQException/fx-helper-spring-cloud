package com.iqexception.fxhelper.common.dto;


import jakarta.validation.constraints.NotNull;

public class Response<T> implements HasResponseStatus {

    @NotNull
    private ResponseStatus status;

    private T result;

    public Response() {
    }

    public Response(ResponseStatus status, T result) {
        this.status = status;
        this.result = result;
    }

    @Override
    public ResponseStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
