package com.iqexception.fxhelper.user.controller;


import com.iqexception.fxhelper.common.constant.CommonConstants;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import com.iqexception.fxhelper.user.controller.dto.*;
import com.iqexception.fxhelper.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Tags(value = {@Tag(name = "User")})
@RefreshScope
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Response<UserLoginResult> login(@RequestBody @Valid Request<UserLoginParam> request, ServletResponse servletResponse) {

        Response<UserLoginResult> response = userService.login(request);
        if (ResponseUtil.isSuccess(response.getStatus())) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setHeader(CommonConstants.HEADER_USER_TOKEN, response.getResult().token());
        }
        return response;
    }

    @PostMapping("/internal/check_login")
    public Response<InternalCheckLoginResult> internalCheckLogin(@RequestBody @Valid InternalCheckLoginRequest request) {

        return userService.internalCheckLogin(request);
    }

    @PostMapping("/internal/get")
    public Response<InternalGetUserResult> internalGet(@RequestBody @Valid InternalGetUserRequest request) {

        return userService.internalGet(request);
    }

    @PostMapping("/internal/get_user_list")
    public Response<InternalGetUserListResult> internalGetUserList(@RequestBody @Valid InternalGetUserListRequest request) {

        return userService.internalGetUserList(request);
    }


    @PostMapping("/internal/change_pay_secret")
    public BaseResponse internalChangePaySecret(@RequestBody @Valid InternalChangePaySecretRequest request) {

        return userService.internalChangePaySecret(request);
    }

    @PostMapping("/internal/verify_pay_secret")
    public Response<InternalVerifyPaySecretResult> internalVerifyPaySecret(@RequestBody @Valid InternalVerifyPaySecretRequest request) {

        return userService.internalVerifyPaySecret(request);
    }

}
