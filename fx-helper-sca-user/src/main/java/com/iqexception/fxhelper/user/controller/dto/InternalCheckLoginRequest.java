package com.iqexception.fxhelper.user.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class InternalCheckLoginRequest {
    @NotBlank
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
