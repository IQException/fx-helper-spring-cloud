package com.iqexception.fxhelper.order.service.builder;


import com.iqexception.fxhelper.order.controller.dto.OrderCreateParam;
import com.iqexception.fxhelper.order.dal.generator.tables.pojos.FxOrder;

import java.math.BigDecimal;

public class OrderBuilder {

    public static FxOrder build(OrderCreateParam param,Long userId) {

        FxOrder order = new FxOrder();
        //FIXME 简单起见，金额写死
        order.setAmount(new BigDecimal(1));
        order.setCapture(param.getCapture());
        order.setShopId(param.getShopId());
        order.setSerialNo(param.getSerialNo());
        order.setUserId(userId);

        return order;
    }
}
