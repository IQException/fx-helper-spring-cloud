package com.iqexception.fxhelper.shop.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class GetShopListResult {

    private List<ShopDetail> shopList = new ArrayList<>();

    public GetShopListResult() {
    }

    public List<ShopDetail> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopDetail> shopList) {
        this.shopList = shopList;
    }

    public GetShopListResult(List<ShopDetail> shopList) {
        this.shopList = shopList;
    }
}
