package com.iqexception.fxhelper.shop.controller.dto;

import com.iqexception.fxhelper.shop.dal.generator.tables.pojos.FxShop;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class ShopDetail {

    @NotNull
    private Long          shopId;
    @NotNull
    private Long          ownerUserId;
    @NotNull
    private String        shopName;
    @NotNull
    private String        logo;
    @NotNull
    private String        intro;
    @NotNull
    private String        address;
    @NotNull
    private String        phone;
    @NotNull
    private Integer       status;
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime updatedAt;

    public ShopDetail(FxShop value) {
        this.shopId = value.getShopId();
        this.ownerUserId = value.getOwnerUserId();
        this.shopName = value.getShopName();
        this.logo = value.getLogo();
        this.intro = value.getIntro();
        this.address = value.getAddress();
        this.phone = value.getPhone();
        this.createdAt = value.getCreatedAt().atOffset(OffsetDateTime.now().getOffset());
        this.updatedAt = value.getUpdatedAt().atOffset(OffsetDateTime.now().getOffset());
        this.status = value.getStatus();
    }

    public ShopDetail() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
