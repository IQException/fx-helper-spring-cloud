package com.iqexception.fxhelper.order.wx;

import com.iqexception.fxhelper.common.BaseService;
import com.iqexception.fxhelper.common.JsonMapper;
import com.iqexception.fxhelper.common.constant.CommonConstants;
import com.iqexception.fxhelper.order.stub.MiscService;
import com.iqexception.fxhelper.order.wx.model.ReceiptMessage;
import com.iqexception.fxhelper.order.wx.model.ValueObject;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
public class WxMsgService extends BaseService {


    private static final String RECEIPT_MESSAGE_ID = "cz-dFqQOL9GgaNA0xc44aD0Y57m6QlsilCXykHrPeSk";

    public static final String PAGE_CONSUMER_ORDER_LIST = "pages/consumer/order_list/order_list";

    private final MiscService miscService;

    public WxMsgService(MessageSource messageSource,
                        JsonMapper jsonMapper,
                        MiscService miscService) {
        super(messageSource, jsonMapper);
        this.miscService = miscService;
    }

    public boolean sendReceiptMessage(String shopName,
                                      String openId,
                                      BigDecimal amount,
                                      Long orderNo,
                                      LocalDateTime payTime) {


        ReceiptMessage message = new ReceiptMessage();
        message.setShopName(new ValueObject(shopName));
        message.setAmount(new ValueObject("￥" + amount.setScale(2, RoundingMode.DOWN)));
        message.setPayTime(new ValueObject(payTime.format(CommonConstants.BASIC_FORMATTER)));
        message.setOrderNo(new ValueObject(orderNo.toString()));

        return miscService.sendMessageQuietly(RECEIPT_MESSAGE_ID, openId, PAGE_CONSUMER_ORDER_LIST, message);

    }
}
