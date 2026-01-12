package com.iqexception.fxhelper.agg.controller.dto;

import com.iqexception.fxhelper.client.resttemplate.shop.model.ShopDetail;
import jakarta.validation.constraints.NotBlank;

public class UserOrderDetail extends com.iqexception.fxhelper.agg.controller.dto.OrderDetail {

    @NotBlank
    private String shopName;
    @NotBlank
    private String shopLogo;

    public UserOrderDetail(com.iqexception.fxhelper.client.resttemplate.order.model.OrderDetail order, ShopDetail shop) {

        super(order);
        this.shopName = shop.getShopName();
        this.shopLogo = shop.getLogo();

    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }
}
