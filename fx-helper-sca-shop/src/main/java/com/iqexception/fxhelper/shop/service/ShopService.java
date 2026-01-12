package com.iqexception.fxhelper.shop.service;


import com.iqexception.fxhelper.common.dto.BaseRequest;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.shop.controller.dto.*;

public interface ShopService {
    Response<ShopCreateResult> create(Request<ShopCreateParam> request);

    BaseResponse update(Request<ShopUpdateParam> request);

    Response<GetShopDetailInfoResult> getDetailInfo(Request<GetDetailInfoParam> request);

    Response<GetShopListResult> getShopList(BaseRequest request);

    BaseResponse switchFx(Request<SwitchParam> request);

    Response<GetQrCodesResult> getQrCodes(Request<GetQrCodesParam> request);

    Response<GetPublicShopInfoResult> getPublicInfo(Request<GetPublicShopInfoParam> request);

    Response<GetShopDetailInfoResult> getDetailInfo(InternalGetDetailInfoRequest request);

    Response<GetShopListResult> internalGetUserShopList(InternalGetUserShopListRequest request);

    Response<GetShopListResult> internalGetShopList(InternalGetShopListRequest request);

    Response<InternalGetSerialNoResult> internalGetSerialNo(InternalGetSerialNoRequest request);
}
