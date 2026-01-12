package com.iqexception.fxhelper.misc.service;

import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.misc.controller.dto.MsgSubsParam;
import com.iqexception.fxhelper.misc.controller.dto.SendWxMessageRequest;

public interface WxMsgService {
    BaseResponse sendMessage(SendWxMessageRequest request);

    BaseResponse msgSubscribe(Request<MsgSubsParam> request);
}
