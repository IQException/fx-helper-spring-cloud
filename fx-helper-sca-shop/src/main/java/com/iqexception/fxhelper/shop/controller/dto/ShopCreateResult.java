package com.iqexception.fxhelper.shop.controller.dto;

import jakarta.validation.constraints.NotNull;

public class ShopCreateResult {
    @NotNull
    private Long shopId;

    public ShopCreateResult() {
    }

    public ShopCreateResult(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
