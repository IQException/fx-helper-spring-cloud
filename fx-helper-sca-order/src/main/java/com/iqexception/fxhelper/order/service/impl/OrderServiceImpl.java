package com.iqexception.fxhelper.order.service.impl;

import com.iqexception.fxhelper.client.resttemplate.account.model.InternalGetAccountResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.GetShopDetailInfoResult;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalGetUserResult;
import com.iqexception.fxhelper.common.BaseService;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.TLVarManager;
import com.iqexception.fxhelper.common.constant.ErrorCode;
import com.iqexception.fxhelper.common.constant.OrderStatus;
import com.iqexception.fxhelper.common.constant.ShopStatus;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.order.constant.BizErrorCode;
import com.iqexception.fxhelper.order.controller.dto.*;
import com.iqexception.fxhelper.order.dal.ext.FxOrderExtDao;
import com.iqexception.fxhelper.order.dal.generator.tables.pojos.FxOrder;
import com.iqexception.fxhelper.order.service.OrderService;
import com.iqexception.fxhelper.order.service.builder.OrderBuilder;
import com.iqexception.fxhelper.order.stub.AccountService;
import com.iqexception.fxhelper.order.stub.PayService;
import com.iqexception.fxhelper.order.stub.ShopService;
import com.iqexception.fxhelper.order.stub.UserService;
import com.iqexception.fxhelper.order.wx.WxMsgService;
import org.jooq.tools.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends BaseService implements OrderService {


    private final FxOrderExtDao orderExtDao;

    private final PayService payService;

    private final AccountService accountService;

    private final UserService userService;

    private final ShopService shopService;

    private final WxMsgService wxMsgService;

    public OrderServiceImpl(MessageSource messageSource,
                            JsonMapper jsonMapper,
                            FxOrderExtDao orderExtDao,
                            PayService payService,
                            AccountService accountService,
                            UserService userService,
                            ShopService shopService,
                            WxMsgService wxMsgService) {
        super(messageSource, jsonMapper);
        this.orderExtDao = orderExtDao;
        this.payService = payService;
        this.accountService = accountService;
        this.userService = userService;
        this.shopService = shopService;
        this.wxMsgService = wxMsgService;
    }

    @Override
    public Response<OrderCreateResult> create(Request<OrderCreateParam> request) {

        GetShopDetailInfoResult shop = shopService.getShopQuietly(request.getParam().getShopId());
        if (shop == null)
            return response(ErrorCode.REQUEST_ERROR);
        if (shop.getStatus() == ShopStatus.CLOSED.getVal())
            return response(BizErrorCode.SHOP_CLOSED);

        String serialNo = shopService.getSerialNoQuietly(request.getParam().getShopId(), request.getParam().getSerialNo());
        if (StringUtils.isBlank(serialNo))
            return response(BizErrorCode.ORDER_NOT_EXIST);

        FxOrder order = orderExtDao.fetchOne(request.getParam().getShopId(), request.getParam().getSerialNo());
        if (order != null)
            return response(BizErrorCode.ORDER_DUPLICATE);

        order = OrderBuilder.build(request.getParam(), TLVarManager.getUserId());

        orderExtDao.insert(OrderBuilder.build(request.getParam(), TLVarManager.getUserId()));

        return responseOk(new OrderCreateResult(order.getId()));
    }

    @Override
    public Response<OrderPayResult> pay(Request<OrderPayParam> request) {


        FxOrder order = orderExtDao.fetchOneById(request.getParam().getOrderId());
        if (order == null)
            return response(ErrorCode.PARAM_ERROR);

        GetShopDetailInfoResult shop = shopService.getShopQuietly(order.getShopId());
        if (shop == null) {
            return response(ErrorCode.REQUEST_ERROR);
        }
        if (shop.getStatus() == ShopStatus.CLOSED.getVal())
            return response(BizErrorCode.SHOP_CLOSED);

        InternalGetUserResult consumer = userService.getUserQuietly(order.getUserId());

        InternalGetAccountResult shopOwner = accountService.getAccountQuietly(TLVarManager.getUserId());
        if (shopOwner == null) {
            return response(ErrorCode.REQUEST_ERROR);
        }

        payService.acct2wxQuietly(shopOwner.getAccountId(), consumer.getOpenId(), order.getAmount());
        //FIXME 暂时默认都成功
        //TODO 分布式事务
        orderExtDao.updateStatus(order.getId(), OrderStatus.SUCCEED.getVal());
        wxMsgService.sendReceiptMessage(
                shop.getShopName(),
                consumer.getOpenId(), order.getAmount(),
                order.getId(), LocalDateTime.now());

        return responseOk();
    }

    @Override
    public Response<InternalGetOrderListResult> internalGetOrderList(InternalGetOrderListRequest request) {
        List<FxOrder> orders = orderExtDao.fetch(request.getShopId(),
                request.getUserId(),
                request.getStatus(),
                request.getFrom(),
                request.getTo(),
                request.getOffset(),
                request.getLimit());
        return responseOk(new InternalGetOrderListResult(
                orders.stream().map(OrderDetail::new).collect(Collectors.toList())));
    }

    @Override
    public Response<InternalGetOrderCountResult> internalGetOrderCount(InternalGetOrderCountRequest request) {

        int count = orderExtDao.count(request.getShopId(), request.getStatus());
        return responseOk(new InternalGetOrderCountResult(count));
    }

    @Override
    public Response<InternalGetOrderTotalAmountResult> internalGetOrderTotalAmount(InternalGetOrderTotalAmountRequest request) {
        BigDecimal amount = orderExtDao.totalAmount(request.getShopId(), request.getStatus());
        return responseOk(new InternalGetOrderTotalAmountResult(amount));
    }


}
