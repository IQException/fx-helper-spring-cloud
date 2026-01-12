package com.iqexception.fxhelper.shop.service.builder;



import com.iqexception.fxhelper.shop.controller.dto.ShopCreateParam;
import com.iqexception.fxhelper.shop.controller.dto.ShopUpdateParam;
import com.iqexception.fxhelper.shop.dal.generator.tables.pojos.FxShop;

import java.time.LocalDateTime;

public class ShopBuilder {
    public static FxShop build(Long userId, ShopCreateParam param) {

        FxShop shop = new FxShop();
        shop.setOwnerUserId(userId);
        shop.setAddress(param.getAddress());
        shop.setShopName(param.getName());
        shop.setIntro(param.getIntro());
        shop.setLogo(param.getLogo());
        shop.setPhone(param.getPhone());

        return shop;
    }

    public static void build(FxShop shop, ShopUpdateParam param) {
        shop.setLogo(param.getLogo());
        shop.setPhone(param.getPhone());
        shop.setShopName(param.getName());
        shop.setIntro(param.getIntro());
        shop.setAddress(param.getAddress());
        shop.setUpdatedAt(LocalDateTime.now());
    }
}
