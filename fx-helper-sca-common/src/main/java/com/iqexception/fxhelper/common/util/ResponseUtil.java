package com.iqexception.fxhelper.common.util;

import com.iqexception.fxhelper.common.constant.ErrorCode;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.common.dto.ResponseStatus;

public class ResponseUtil {


    public static ResponseStatus statusOk() {
        ResponseStatus STATUS_OK = new ResponseStatus();
        STATUS_OK.setErrorCode(String.valueOf(ErrorCode.SUCCESS));
        return STATUS_OK;
    }

    public static boolean isSuccess(ResponseStatus status) {
        return status.getErrorCode().equals(String.valueOf(ErrorCode.SUCCESS));
    }

    public static boolean isSuccess(int errorCode) {
        return errorCode == ErrorCode.SUCCESS;
    }

    public static boolean isSuccess(String errorCode) {
        return String.valueOf(ErrorCode.SUCCESS).equals(errorCode);
    }

    public static boolean isFail(ResponseStatus status) {
        return !isSuccess(status);
    }

    public static boolean isFail(int errorCode) {
        return !isSuccess(errorCode);
    }

    public static boolean isFail(String errorCode) {
        return !isSuccess(errorCode);
    }

    public static <T> Response<T> responseOk() {
        return responseOk(null);
    }

    public static <T> Response<T> responseOk(T result) {
        return new Response<>(statusOk(), result);
    }

    public static <T> Response<T> response(ResponseStatus status) {
        return new Response<>(status, null);
    }

}
