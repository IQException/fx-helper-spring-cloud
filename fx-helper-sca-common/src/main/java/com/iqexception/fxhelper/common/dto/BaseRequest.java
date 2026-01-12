package com.iqexception.fxhelper.common.dto;


public class BaseRequest implements HasMobileRequestHead {
    private MobileRequestHead head;

    @Override
    public MobileRequestHead getHead() {
        return head;
    }

    @Override
    public void setHead(MobileRequestHead head) {
        this.head = head;
    }
}
