package com.iqexception.fxhelper.shop.service.impl;

import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import com.iqexception.fxhelper.common.BaseService;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.RmqHelper;
import com.iqexception.fxhelper.common.TLVarManager;
import com.iqexception.fxhelper.common.constant.ErrorCode;
import com.iqexception.fxhelper.common.dto.*;
import com.iqexception.fxhelper.common.util.ResponseUtil;
import com.iqexception.fxhelper.shop.constant.BizErrorCode;
import com.iqexception.fxhelper.shop.constant.WxConstants;
import com.iqexception.fxhelper.shop.controller.dto.*;
import com.iqexception.fxhelper.shop.dal.ext.FxSerialNoExtDao;
import com.iqexception.fxhelper.shop.dal.ext.FxShopExtDao;
import com.iqexception.fxhelper.shop.dal.generator.tables.pojos.FxSerialNo;
import com.iqexception.fxhelper.shop.dal.generator.tables.pojos.FxShop;
import com.iqexception.fxhelper.shop.service.ShopService;
import com.iqexception.fxhelper.shop.service.builder.ShopBuilder;
import com.iqexception.fxhelper.shop.stub.UserService;
import com.iqexception.fxhelper.shop.wx.WxApi;
import org.springframework.context.MessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl extends BaseService implements ShopService {

    private final WxApi wxApi;

    private final FxShopExtDao shopExtDao;

    private final UserService userService;

    private final FxSerialNoExtDao serialNoExtDao;

    public ShopServiceImpl(MessageSource messageSource,
                           JsonMapper jsonMapper,
                           StringRedisTemplate redisTemplate,
                           RmqHelper rmqHelper,
                           WxApi wxApi,
                           FxShopExtDao shopExtDao,
                           UserService userService,
                           FxSerialNoExtDao serialNoExtDao) {
        super(messageSource, jsonMapper, redisTemplate, rmqHelper);
        this.wxApi = wxApi;
        this.shopExtDao = shopExtDao;
        this.userService = userService;
        this.serialNoExtDao = serialNoExtDao;

    }


    @Override
    public Response<ShopCreateResult> create(Request<ShopCreateParam> request) {

        FxShop shop = ShopBuilder.build(TLVarManager.getUserId(), request.getParam());

        shopExtDao.insert(shop);
        // 支付密码暂放在用户域（支付密码这块设计得有点问题，因为支付密码跟着用户走，应当在创建用户的时候设置（或第一次支付时）；先这么着吧）
        //FIXME 发消息
        userService.updatePaySecretQuietly(TLVarManager.getUserId(),
                request.getParam().getPaySecret());

        return responseOk(new ShopCreateResult(shop.getShopId()));
    }

    @Override
    public BaseResponse update(Request<ShopUpdateParam> request) {

        FxShop shop = shopExtDao.fetchOneByShopId(request.getParam().getShopId());

        if (shop == null || !TLVarManager.getUserId().equals(shop.getOwnerUserId()))
            return new BaseResponse(status(ErrorCode.PARAM_ERROR));

        ShopBuilder.build(shop, request.getParam());
        shopExtDao.update(shop);

        return new BaseResponse(ResponseUtil.statusOk());
    }

    @Override
    public Response<GetShopDetailInfoResult> getDetailInfo(Request<GetDetailInfoParam> request) {

        FxShop shop = shopExtDao.fetchOneByShopId(request.getParam().getShopId());

        if (shop == null || !TLVarManager.getUserId().equals(shop.getOwnerUserId()))
            return response(ErrorCode.PARAM_ERROR);

        return responseOk(new GetShopDetailInfoResult(shop));
    }

    @Override
    public Response<GetShopListResult> getShopList(BaseRequest request) {

        return getShopList(TLVarManager.getUserId());
    }

    @Override
    public BaseResponse switchFx(Request<SwitchParam> request) {

        ResponseStatus status = validateShopAndOwner(
                request.getParam().getShopId(),
                TLVarManager.getUserId());
        if (ResponseUtil.isFail(status)) {
            return new BaseResponse(status);
        }

        shopExtDao.updateStatus(request.getParam().getShopId(),
                request.getParam().getSwitchValue());

        return new BaseResponse(ResponseUtil.statusOk());
    }

    @Override
    public Response<GetQrCodesResult> getQrCodes(Request<GetQrCodesParam> request) {

        ResponseStatus status = validateShopAndOwner(
                request.getParam().getShopId(),
                TLVarManager.getUserId());
        if (ResponseUtil.isFail(status))
            return response(status);

        List<FxSerialNo> serialNos = Lists.newArrayList();

        for (int i = 0; i < request.getParam().getNumber(); i++) {

            FxSerialNo serialNo = new FxSerialNo();
            serialNo.setShopId(request.getParam().getShopId());
            byte[] hashBytes = Hashing.crc32().hashBytes(
                    UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)).asBytes();
            serialNo.setSerialNo(new String(Base64.getEncoder().encode(hashBytes), StandardCharsets.UTF_8));
            serialNos.add(serialNo);
        }

        serialNoExtDao.insert(serialNos);

        List<String> qrCodes = wxApi.getQrCodes(WxConstants.PAGE_CONSUMER_LANDING,
                serialNos.stream().map(e -> request.getParam().getShopId() + "#" + e.getSerialNo())
                        .collect(Collectors.toList()));

        return responseOk(new GetQrCodesResult(qrCodes));
    }

    @Override
    public Response<GetPublicShopInfoResult> getPublicInfo(Request<GetPublicShopInfoParam> request) {


        FxShop shop = shopExtDao.fetchOneByShopId(request.getParam().getShopId());

        if (shop == null)
            return response(ErrorCode.PARAM_ERROR);
        GetPublicShopInfoResult result = new GetPublicShopInfoResult();
        result.setAddress(shop.getAddress());
        result.setLogo(shop.getLogo());
        result.setShopName(shop.getShopName());
        result.setIntro(shop.getIntro());
        return responseOk(result);
    }

    @Override
    public Response<GetShopDetailInfoResult> getDetailInfo(InternalGetDetailInfoRequest request) {

        FxShop shop = shopExtDao.fetchOneByShopId(request.getShopId());
        if (shop == null) {
            return response(BizErrorCode.SHOP_NOT_EXIST);
        }
        return responseOk(new GetShopDetailInfoResult(shop));
    }

    @Override
    public Response<GetShopListResult> internalGetUserShopList(InternalGetUserShopListRequest request) {

        return getShopList(request.getUserId());
    }

    @Override
    public Response<GetShopListResult> internalGetShopList(InternalGetShopListRequest request) {

        List<FxShop> shops = shopExtDao.fetchByShopId(request.getShopIds().toArray(new Long[0]));

        return responseOk(
                new GetShopListResult(
                        shops.stream()
                                .map(ShopDetail::new)
                                .collect(Collectors.toList())));
    }

    @Override
    public Response<InternalGetSerialNoResult> internalGetSerialNo(InternalGetSerialNoRequest request) {
        FxSerialNo serialNo = serialNoExtDao.fetchOne(request.getShopId(), request.getSerialNo());
        if (serialNo == null)
            return response(BizErrorCode.SERIAL_NO_NOT_EXIST);
        return responseOk(new InternalGetSerialNoResult(serialNo.getSerialNo()));
    }

    private Response<GetShopListResult> getShopList(Long userId) {

        List<FxShop> shops = shopExtDao.fetchByOwnerUserId(userId);

        return responseOk(
                new GetShopListResult(
                        shops.stream()
                                .map(ShopDetail::new)
                                .collect(Collectors.toList())));
    }

    private ResponseStatus validateShopAndOwner(Long shopId, Long userId) {

        FxShop shop = shopExtDao.fetchOneByShopId(shopId);
        if (shop == null || !shop.getOwnerUserId().equals(userId))
            return status(ErrorCode.PARAM_ERROR);

        return ResponseUtil.statusOk();
    }

}
