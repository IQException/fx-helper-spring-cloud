package com.iqexception.fxhelper.shop.controller;


import com.iqexception.fxhelper.common.dto.BaseRequest;
import com.iqexception.fxhelper.common.dto.BaseResponse;
import com.iqexception.fxhelper.common.dto.Request;
import com.iqexception.fxhelper.common.dto.Response;
import com.iqexception.fxhelper.shop.controller.dto.*;
import com.iqexception.fxhelper.shop.service.ShopService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tags(value = {@Tag(name = "Shop")})
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/create")
    public Response<ShopCreateResult> create(@RequestBody @Valid Request<ShopCreateParam> request) {
        return shopService.create(request);
    }

    @PostMapping("/update")
    public BaseResponse update(@RequestBody @Valid Request<ShopUpdateParam> request) {
        return shopService.update(request);
    }

    @PostMapping("/get_public_info")
    public Response<GetPublicShopInfoResult> getPublicInfo(@RequestBody @Valid Request<GetPublicShopInfoParam> request) {
        return shopService.getPublicInfo(request);
    }

    @PostMapping("/get_detail_info")
    public Response<GetShopDetailInfoResult> getDetailInfo(@RequestBody @Valid Request<GetDetailInfoParam> request) {
        return shopService.getDetailInfo(request);
    }

    @PostMapping("/internal/get_detail_info")
    public Response<GetShopDetailInfoResult> internalGetDetailInfo(@RequestBody @Valid InternalGetDetailInfoRequest request) {
        return shopService.getDetailInfo(request);
    }

    @PostMapping("/get_shop_list")
    public Response<GetShopListResult> getShopList(@RequestBody @Valid BaseRequest request) {
        return shopService.getShopList(request);
    }

    @PostMapping("/internal/get_user_shop_list")
    public Response<GetShopListResult> internalGetUserShopList(@RequestBody @Valid InternalGetUserShopListRequest request) {
        return shopService.internalGetUserShopList(request);
    }

    @PostMapping("/internal/get_shop_list")
    public Response<GetShopListResult> internalGetShopList(@RequestBody @Valid InternalGetShopListRequest request) {
        return shopService.internalGetShopList(request);
    }

    @PostMapping("/internal/get_serial_no")
    public Response<InternalGetSerialNoResult> internalGetSerialNo(@RequestBody @Valid InternalGetSerialNoRequest request) {
        return shopService.internalGetSerialNo(request);
    }

    @PostMapping("/switch")
    public BaseResponse switchFx(@RequestBody @Valid Request<SwitchParam> request) {
        return shopService.switchFx(request);
    }

    @PostMapping("/get_qr_codes")
    public Response<GetQrCodesResult> getQrCodes(@RequestBody @Valid Request<GetQrCodesParam> request) {
        return shopService.getQrCodes(request);
    }





}
