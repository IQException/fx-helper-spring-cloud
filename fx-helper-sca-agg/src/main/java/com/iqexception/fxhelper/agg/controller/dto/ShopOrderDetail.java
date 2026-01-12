package com.iqexception.fxhelper.agg.controller.dto;


import com.iqexception.fxhelper.client.resttemplate.user.model.UserInfo;
import jakarta.validation.constraints.NotBlank;

public class ShopOrderDetail extends com.iqexception.fxhelper.agg.controller.dto.OrderDetail {

    @NotBlank
    private String nickName;
    @NotBlank
    private String avatar;


    public ShopOrderDetail() {
    }

    public ShopOrderDetail(com.iqexception.fxhelper.client.resttemplate.order.model.OrderDetail order, UserInfo user) {
        super(order);
        this.nickName = user.getNickName();
        this.avatar = user.getAvatar();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
