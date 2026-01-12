package com.iqexception.fxhelper.agg.service.impl;

import com.iqexception.fxhelper.agg.controller.dto.*;
import com.iqexception.fxhelper.agg.service.AggService;
import com.iqexception.fxhelper.agg.stub.AccountService;
import com.iqexception.fxhelper.agg.stub.OrderService;
import com.iqexception.fxhelper.agg.stub.ShopService;
import com.iqexception.fxhelper.agg.stub.UserService;
import com.iqexception.fxhelper.client.resttemplate.account.model.InternalGetAccountResult;
import com.iqexception.fxhelper.client.resttemplate.order.model.OrderDetail;
import com.iqexception.fxhelper.client.resttemplate.shop.model.GetShopDetailInfoResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ShopDetail;
import com.iqexception.fxhelper.client.resttemplate.user.model.UserInfo;
import com.iqexception.fxhelper.common.BaseService;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.TLVarManager;
import com.iqexception.fxhelper.common.constant.ErrorCode;
import com.iqexception.fxhelper.common.constant.OrderStatus;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AggServiceImpl extends BaseService implements AggService {

    private final UserService userService;

    private final OrderService orderService;

    private final ShopService shopService;

    private final AccountService accountService;


    public AggServiceImpl(MessageSource messageSource,
                          JsonMapper jsonMapper,
                          UserService userService,
                          OrderService orderService,
                          ShopService shopService,
                          AccountService accountService) {
        super(messageSource, jsonMapper);
        this.userService = userService;
        this.orderService = orderService;
        this.shopService = shopService;
        this.accountService = accountService;
    }

    @Override
    public Response<ShopOrderListResult> listShopOrders(Request<ShopOrderListParam> request) {
        GetShopDetailInfoResult shop = shopService.getShopQuietly(request.getParam().getShopId());
        if (shop == null
                || !shop.getOwnerUserId().equals(TLVarManager.getUserId()))
            return response(ErrorCode.PARAM_ERROR);

        ShopOrderListParam param = request.getParam();
        List<OrderDetail> orderList = orderService.getOrderListQuietly(param.getShopId(), null, param.getStatus(),
                param.getFrom(), param.getTo(), param.getOffset(), param.getLimit());

        List<Long> userIds = orderList.stream().map(OrderDetail::getUserId)
                .distinct().toList();

        if (!userIds.isEmpty()) {

            Map<Long, UserInfo> userMap = userService.getUserListQuietly(userIds)
                    .stream().collect(Collectors.toMap(UserInfo::getUserId, e -> e));

            return responseOk(new ShopOrderListResult(
                    orderList.stream().map(e -> new ShopOrderDetail(e, userMap.get(e.getUserId())))
                            .collect(Collectors.toList())));
        }
        return ResponseUtil.responseOk();


    }

    @Override
    public Response<GetShopResult> getShop(Request<GetShopParam> request) {
        GetShopDetailInfoResult shop = shopService.getShopQuietly(request.getParam().getShopId());

        Long userId = TLVarManager.getUserId();
        if (shop == null
                || !userId.equals(shop.getOwnerUserId()))
            return response(ErrorCode.PARAM_ERROR);

        InternalGetAccountResult account = accountService.getAccountQuietly(userId);

        int orderCount = orderService.getOrderCountQuietly(shop.getShopId(), OrderStatus.SUCCEED.getVal());

        BigDecimal orderTotalAmount = orderService.getOrderTotalAmountQuietly(shop.getShopId(), OrderStatus.SUCCEED.getVal());

        return responseOk(new GetShopResult(shop, account, orderCount, orderTotalAmount));

    }

    @Override
    public Response<UserOrderListResult> listUserOrders(Request<UserOrderListParam> request) {


        UserOrderListParam param = request.getParam();
        List<OrderDetail> orderList = orderService.getOrderListQuietly(
                null,
                TLVarManager.getUserId(),
                param.getStatus(),
                param.getFrom(),
                param.getTo(),
                param.getOffset(),
                param.getLimit());

        List<Long> shopIds = orderList.stream().map(OrderDetail::getShopId)
                .distinct().toList();

        if (!shopIds.isEmpty()) {

            Map<Long, ShopDetail> shopMap = shopService.getShopListQuietly(shopIds)
                    .stream().collect(Collectors.toMap(ShopDetail::getShopId, e -> e));

            return responseOk(new UserOrderListResult(
                    orderList.stream().map(e -> new UserOrderDetail(e, shopMap.get(e.getShopId())))
                            .collect(Collectors.toList())));
        }

        return ResponseUtil.responseOk();

    }
}
