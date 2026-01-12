package com.iqexception.fxhelper.order.controller;


import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.order.controller.dto.*;
import com.iqexception.fxhelper.order.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tags(value = {@Tag(name = "Order")})
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Response<OrderCreateResult> create(@RequestBody @Valid Request<OrderCreateParam> request) {
        return orderService.create(request);
    }

    @PostMapping("/pay")
    public Response<OrderPayResult> pay(@RequestBody @Valid Request<OrderPayParam> request) {
        return orderService.pay(request);
    }

    @PostMapping("/internal/get_order_list")
    public Response<InternalGetOrderListResult> internalGetOrderList(@RequestBody @Valid InternalGetOrderListRequest request) {
        return orderService.internalGetOrderList(request);
    }

    @PostMapping("/internal/get_order_count")
    public Response<InternalGetOrderCountResult> internalGetOrderCount(@RequestBody @Valid InternalGetOrderCountRequest request) {
        return orderService.internalGetOrderCount(request);
    }

    @PostMapping("/internal/get_order_total_amount")
    public Response<InternalGetOrderTotalAmountResult> internalGetTotalAmount(@RequestBody @Valid InternalGetOrderTotalAmountRequest request) {
        return orderService.internalGetOrderTotalAmount(request);
    }


}
