package com.iqexception.fxhelper.pay.controller;


import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.pay.controller.dto.*;
import com.iqexception.fxhelper.pay.service.PayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tags(value = {@Tag(name = "Pay")})
public class PayController {

    private final PayService payService;

    public PayController(PayService payService) {
        this.payService = payService;
    }

    @PostMapping("/deposit")
    public Response<DepositResult> deposit(@RequestBody @Valid Request<DepositParam> request) {
        return payService.deposit(request);
    }

    @PostMapping("/withdraw")
    public Response<WithdrawResult> withdraw(@RequestBody @Valid Request<WithdrawParam> request) {
        return payService.withdraw(request);
    }

    @PostMapping("/internal/acct2wx")
    public Response<InternalAcct2wxResult> acct2wx(@RequestBody Acct2wxRequest request) {
        return payService.acct2wx(request);
    }

    @PostMapping("/pay_notify")
    public ResponseEntity<String> payNotify(@RequestBody String body,
                                            @RequestHeader("Wechatpay-Signature") String sign,
                                            @RequestHeader("Wechatpay-Serial") String serial,
                                            @RequestHeader("Wechatpay-Nonce") String nonce,
                                            @RequestHeader("Wechatpay-Timestamp") String timestamp,
                                            @RequestHeader("Wechatpay-Signature-Type") String signType) {

        return payService.payNotify(body, sign, serial, nonce, timestamp, signType);


    }


}
