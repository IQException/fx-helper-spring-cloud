package com.iqexception.fxhelper.misc.service;

import com.iqexception.fxhelper.common.dto.BaseRequest;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.misc.controller.dto.GetUploadPolicyResult;

public interface AliyunService {
    Response<GetUploadPolicyResult> getUploadPolicy(BaseRequest request);
}
