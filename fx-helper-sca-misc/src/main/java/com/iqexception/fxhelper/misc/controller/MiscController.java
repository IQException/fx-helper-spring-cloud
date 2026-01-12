package com.iqexception.fxhelper.misc.controller;

import com.iqexception.fxhelper.common.dto.BaseRequest;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import com.iqexception.fxhelper.misc.controller.dto.GetAccessTokenResult;
import com.iqexception.fxhelper.misc.controller.dto.GetUploadPolicyResult;
import com.iqexception.fxhelper.misc.controller.dto.MsgSubsParam;
import com.iqexception.fxhelper.misc.controller.dto.SendWxMessageRequest;
import com.iqexception.fxhelper.misc.service.AliyunService;
import com.iqexception.fxhelper.misc.service.WxApi;
import com.iqexception.fxhelper.misc.service.WxMsgService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tags(value = {@Tag(name = "Misc")})
public class MiscController {

    private final WxApi wxApi;

    private final WxMsgService wxMsgService;

    private final AliyunService aliyunService;

    public MiscController(WxApi wxApi, WxMsgService wxMsgService, AliyunService aliyunService) {
        this.wxApi = wxApi;
        this.wxMsgService = wxMsgService;
        this.aliyunService = aliyunService;
    }

    @PostMapping("/wx/get_access_token")
    public Response<GetAccessTokenResult> getAccessToken() {
        return ResponseUtil.responseOk(new GetAccessTokenResult(wxApi.getAccessToken()));
    }

    @PostMapping("/wx/msg_subscribe")
    public BaseResponse msgSubscribe(@RequestBody @Valid Request<MsgSubsParam> request) {
        return wxMsgService.msgSubscribe(request);
    }

    // TODO: async_send_message
    @PostMapping("/wx/send_message")
    public BaseResponse sendMessage(@RequestBody @Valid SendWxMessageRequest request) {
        return wxMsgService.sendMessage(request);
    }

    @PostMapping("/get_upload_policy")
    public Response<GetUploadPolicyResult> getUploadPolicy(@RequestBody @Valid BaseRequest request) {
        return aliyunService.getUploadPolicy(request);
    }

}
