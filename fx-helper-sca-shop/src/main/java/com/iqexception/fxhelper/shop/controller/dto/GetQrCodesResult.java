package com.iqexception.fxhelper.shop.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class GetQrCodesResult {

    private List<String> qrCodes = new ArrayList<>();;

    public GetQrCodesResult( List<String> qrCodes) {
        this.qrCodes = qrCodes;
    }

    public GetQrCodesResult() {
    }

    public List<String> getQrCodes() {
        return qrCodes;
    }

    public void setQrCodes(List<String> qrCodes) {
        this.qrCodes = qrCodes;
    }


}
