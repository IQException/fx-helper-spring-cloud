package com.iqexception.fxhelper.user.service;


import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.user.controller.dto.*;

public interface UserService {

    Response<UserLoginResult> login(Request<UserLoginParam> request);

    Response<InternalVerifyPaySecretResult> internalVerifyPaySecret(InternalVerifyPaySecretRequest request);

    Response<InternalCheckLoginResult> internalCheckLogin(InternalCheckLoginRequest request);

    BaseResponse internalChangePaySecret(InternalChangePaySecretRequest request);

    Response<InternalGetUserResult> internalGet(InternalGetUserRequest request);

    Response<InternalGetUserListResult> internalGetUserList(InternalGetUserListRequest request);
}
