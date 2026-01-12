package com.iqexception.fxhelper.shop.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class InternalGetShopListRequest {
    @NotEmpty
    @NotNull
    private List<Long> shopIds;

    public List<Long> getShopIds() {
        return shopIds;
    }

    public void setShopIds(List<Long> shopIds) {
        this.shopIds = shopIds;
    }
}
