package com.iqexception.fxhelper.agg.controller.dto;

import com.iqexception.fxhelper.client.resttemplate.shop.model.ShopDetail;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetail {

    @NotNull
    private Long id;
    @NotNull
    private Long shopId;
    @NotNull
    private Long userId;
    @NotNull
    private String capture;
    @NotNull
    private BigDecimal amount;
    private LocalDateTime fxTime;
    @NotNull
    private Integer status;
    private String failMsg;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;

    public OrderDetail() {
    }
    public OrderDetail(com.iqexception.fxhelper.client.resttemplate.order.model.OrderDetail order) {
        this.setId(order.getId());
        this.setShopId(order.getShopId());
        this.setUserId(order.getUserId());
        this.setCapture(order.getCapture());
        this.setAmount(order.getAmount());
        this.setFxTime(order.getFxTime() == null ? null : order.getFxTime().toLocalDateTime());
        this.setStatus(order.getStatus());
        this.setFailMsg(order.getFailMsg());
        this.setCreatedAt(order.getCreatedAt().toLocalDateTime());
        this.setUpdatedAt(order.getUpdatedAt().toLocalDateTime());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCapture() {
        return capture;
    }

    public void setCapture(String capture) {
        this.capture = capture;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getFxTime() {
        return fxTime;
    }

    public void setFxTime(LocalDateTime fxTime) {
        this.fxTime = fxTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
