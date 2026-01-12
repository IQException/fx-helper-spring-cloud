package com.iqexception.fxhelper.user.controller.dto;

import com.iqexception.fxhelper.user.dal.generator.tables.pojos.FxUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InternalGetUserResult {
    @NotNull
    private Long userId;
    @NotBlank
    private String nickName;
    @NotBlank
    private String avatar;
    @NotBlank
    private String openId;
    private String unionId;
    @NotBlank
    private String phone;

    public InternalGetUserResult() {
    }

    public InternalGetUserResult(FxUser value) {
        this.userId = value.getUserId();
        this.nickName = value.getNickName();
        this.avatar = value.getAvatar();
        this.openId = value.getOpenId();
        this.unionId = value.getUnionId();
        this.phone = value.getPhone();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
