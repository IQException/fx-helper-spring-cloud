package com.iqexception.fxhelper.account.service;

import com.iqexception.fxhelper.account.controller.dto.*;
import com.iqexception.fxhelper.common.dto.BaseRequest;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Response;


public interface AccountService {

    Response<InternalAccountTransferResult> internalTransfer(InternalTransferRequest request);

    Response<InternalGetAccountResult> internalGet(InternalGetAccountRequest request);

    Response<GetAccountResult> get(BaseRequest request);

    Response<InternalAccountCreateResult> internalCreate(InternalCreateRequest request);

    BaseResponse internalIncrBalance(IncrBalanceRequest request);
}
