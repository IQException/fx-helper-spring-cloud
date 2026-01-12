package com.iqexception.fxhelper.account.controller;


import com.iqexception.fxhelper.account.controller.dto.*;
import com.iqexception.fxhelper.account.service.AccountService;
import com.iqexception.fxhelper.common.dto.BaseRequest;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tags(value = {@Tag(name = "Account")})
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/internal/create")
    public Response<InternalAccountCreateResult> internalCreate(@RequestBody @Valid InternalCreateRequest request) {
        return accountService.internalCreate(request);
    }

    @PostMapping("/internal/transfer")
    public Response<InternalAccountTransferResult> internalTransfer(@RequestBody @Valid InternalTransferRequest request) {
        return accountService.internalTransfer(request);
    }

    @PostMapping("/internal/get_account")
    public Response<InternalGetAccountResult> internalGet(@RequestBody @Valid InternalGetAccountRequest request) {
        return accountService.internalGet(request);
    }

    @PostMapping("/internal/incr_balance")
    public BaseResponse internalIncrBalance(@RequestBody @Valid IncrBalanceRequest request) {
        return accountService.internalIncrBalance(request);
    }

    @PostMapping("/get_account")
    public Response<GetAccountResult> get(@RequestBody @Valid BaseRequest request) {
        return accountService.get(request);
    }
}
