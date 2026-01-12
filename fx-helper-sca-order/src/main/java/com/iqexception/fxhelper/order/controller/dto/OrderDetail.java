package com.iqexception.fxhelper.order.controller.dto;

import com.iqexception.fxhelper.order.dal.generator.tables.pojos.FxOrder;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

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
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime updatedAt;

    public OrderDetail() {
    }

    public OrderDetail(FxOrder order) {
        this.id = order.getId();
        this.shopId = order.getShopId();
        this.userId = order.getUserId();
        this.capture = order.getCapture();
        this.amount = order.getAmount();
        this.fxTime = order.getFxTime();
        this.status = order.getStatus();
        this.failMsg = order.getFailMsg();
        this.createdAt = order.getCreatedAt().atOffset(OffsetDateTime.now().getOffset());
        this.updatedAt = order.getUpdatedAt().atOffset(OffsetDateTime.now().getOffset());
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
