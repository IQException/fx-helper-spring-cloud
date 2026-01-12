package com.iqexception.fxhelper.misc.controller.dto;

public class GetAccessTokenResult {
    private String accessToken;

    public GetAccessTokenResult() {
    }

    public GetAccessTokenResult(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
