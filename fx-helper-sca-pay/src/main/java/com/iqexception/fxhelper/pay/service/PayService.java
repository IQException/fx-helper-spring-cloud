package com.iqexception.fxhelper.pay.service;


import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.pay.controller.dto.*;
import org.springframework.http.ResponseEntity;

public interface PayService {
    Response<DepositResult> deposit(Request<DepositParam> request);

    Response<WithdrawResult> withdraw(Request<WithdrawParam> request);

    ResponseEntity<String> payNotify(String body,
                                     String sign,
                                     String serial,
                                     String nonce,
                                     String timestamp,
                                     String signType);

    Response<InternalAcct2wxResult> acct2wx(Acct2wxRequest request);
}
