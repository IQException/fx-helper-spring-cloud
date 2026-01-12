package com.iqexception.fxhelper.pay.service.impl;

import com.iqexception.fxhelper.client.resttemplate.account.model.InternalGetAccountResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ShopDetail;
import com.iqexception.fxhelper.common.BaseService;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.TLVarManager;
import com.iqexception.fxhelper.common.constant.ErrorCode;
import com.iqexception.fxhelper.common.constant.PayChannel;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.pay.constant.BillType;
import com.iqexception.fxhelper.pay.controller.dto.*;
import com.iqexception.fxhelper.pay.dal.ext.FxPayInfoExtDao;
import com.iqexception.fxhelper.pay.dal.generator.tables.pojos.FxPayInfo;
import com.iqexception.fxhelper.pay.service.PayService;
import com.iqexception.fxhelper.pay.service.builder.PayInfoBuilder;
import com.iqexception.fxhelper.pay.stub.AccountService;
import com.iqexception.fxhelper.pay.stub.ShopService;
import com.iqexception.fxhelper.pay.wx.WxMsgService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FakePayService extends BaseService implements PayService {


    private final FxPayInfoExtDao payInfoExtDao;

    private final AccountService accountService;

    private final WxMsgService wxMsgService;

    private final ShopService shopService;

    public FakePayService(MessageSource messageSource,
                          JsonMapper jsonMapper,
                          FxPayInfoExtDao payInfoExtDao,
                          AccountService accountService,
                          WxMsgService wxMsgService,
                          ShopService shopService) {
        super(messageSource, jsonMapper);
        this.payInfoExtDao = payInfoExtDao;
        this.accountService = accountService;
        this.shopService = shopService;
        this.wxMsgService = wxMsgService;
    }

    @Override
    public Response<DepositResult> deposit(Request<DepositParam> request) {

        Long userId = TLVarManager.getUserId();
        String openId = TLVarManager.getOpenId();

        InternalGetAccountResult account = accountService.getAccountQuietly(userId);
        if (account == null) {
            return response(ErrorCode.REQUEST_ERROR);
        }
        FxPayInfo payInfo = new FxPayInfo();
        payInfo.setAmount(request.getParam().getAmount());
        payInfo.setFromAccount(openId);
        payInfo.setFromChannel(PayChannel.WX.getVal());
        payInfo.setToAccount(account.getAccountId().toString());
        payInfo.setToChannel(PayChannel.ACCOUNT.getVal());
        payInfo.setBizId(openId + PayInfoBuilder.BIZ_ID_SEPARATOR_WX + System.currentTimeMillis());
        //fake
        payInfo.setFromTrxId("fake");
        payInfo.setStatus("fake");
        // FIXME 状态管理
        payInfoExtDao.insert(payInfo);

        accountService.incrBalanceQuietly(account.getAccountId(), request.getParam().getAmount());

        List<ShopDetail> shops = shopService.getShopListQuietly(userId);
        wxMsgService.sendBillMessage(BillType.DEPOSIT, shops.getFirst().getShopId(), shops.getFirst().getShopName(),
                openId, request.getParam().getAmount(), payInfo.getId(), LocalDateTime.now());

        return responseOk();
    }

    @Override
    public Response<WithdrawResult> withdraw(Request<WithdrawParam> request) {

        Long userId = TLVarManager.getUserId();
        String openId = TLVarManager.getOpenId();

        InternalGetAccountResult account = accountService.getAccountQuietly(userId);
        if (account == null)
            return response(ErrorCode.REQUEST_ERROR);

        FxPayInfo payInfo = acct2wx(account.getAccountId(), openId, request.getParam().getAmount());

        // FIXME 状态管理
        List<ShopDetail> shops = shopService.getShopListQuietly(userId);
        wxMsgService.sendBillMessage(
                BillType.WITHDRAW, shops.getFirst().getShopId(), shops.getFirst().getShopName(),
                openId, request.getParam().getAmount(),
                payInfo.getId(), LocalDateTime.now());

        return responseOk();
    }

    private FxPayInfo acct2wx(Long accountId, String openId, BigDecimal amount) {

        //生成订单
        FxPayInfo payInfo = PayInfoBuilder.build(amount, accountId, openId);
        payInfoExtDao.insert(payInfo);

        //先扣余额
        boolean success = accountService.incrBalanceQuietly(accountId, amount.negate());
        // FIXME 状态管理
//        if(!success){
//            payInfoExtDao.updateStatus();
//        }

        // FIXME 转账
        // wxApi.initTransfer(payInfo.getId(), amount, openId);
        // FIXME 状态管理
        // TODO
        return payInfo;
    }

    @Override
    public ResponseEntity<String> payNotify(String body,
                                            String sign,
                                            String serial,
                                            String nonce,
                                            String timestamp,
                                            String signType) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public Response<InternalAcct2wxResult> acct2wx(Acct2wxRequest request) {
        FxPayInfo payInfo = acct2wx(request.getAccountId(), request.getOpenId(), request.getAmount());
        if(payInfo == null)
            return response(ErrorCode.REQUEST_ERROR);
        return responseOk(new InternalAcct2wxResult(payInfo.getId()));
    }
}
