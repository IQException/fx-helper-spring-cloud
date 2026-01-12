package com.iqexception.fxhelper.agg.controller.dto;


import java.util.ArrayList;
import java.util.List;

public class ShopOrderListResult {

    private List<ShopOrderDetail> orderList = new ArrayList<>();

    public ShopOrderListResult() {
    }

    public ShopOrderListResult(List<ShopOrderDetail> orderList) {
        this.orderList = orderList;
    }

    public List<ShopOrderDetail> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ShopOrderDetail> orderList) {
        this.orderList = orderList;
    }
}
