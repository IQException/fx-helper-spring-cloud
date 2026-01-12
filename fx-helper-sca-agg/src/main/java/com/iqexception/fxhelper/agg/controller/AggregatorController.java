package com.iqexception.fxhelper.agg.controller;


import com.iqexception.fxhelper.agg.controller.dto.*;
import com.iqexception.fxhelper.agg.service.AggService;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tags(value = {@Tag(name = "Aggregator")})
public class AggregatorController {

    private final AggService aggService;

    public AggregatorController(AggService aggService) {
        this.aggService = aggService;
    }

    @PostMapping("/list_shop_orders")
    public Response<ShopOrderListResult> listShopOrders(@RequestBody @Valid Request<ShopOrderListParam> request) {
        return aggService.listShopOrders(request);
    }

    @PostMapping("list_user_orders")
    public Response<UserOrderListResult> listUserOrders(@RequestBody @Valid Request<UserOrderListParam> request) {
        return aggService.listUserOrders(request);
    }

    @PostMapping("/get_shop")
    public  Response<GetShopResult> getShop(@RequestBody @Valid Request<GetShopParam> request){
        return aggService.getShop(request);
    }

}
