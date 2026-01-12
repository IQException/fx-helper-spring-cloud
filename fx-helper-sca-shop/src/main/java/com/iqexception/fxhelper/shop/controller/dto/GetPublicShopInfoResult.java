package com.iqexception.fxhelper.shop.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class GetPublicShopInfoResult {
    @NotBlank
    private String        shopName;
    @NotBlank
    private String        logo;
    @NotBlank
    private String        intro;
    @NotBlank
    private String        address;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
