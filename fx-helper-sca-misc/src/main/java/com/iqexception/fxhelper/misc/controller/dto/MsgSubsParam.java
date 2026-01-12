package com.iqexception.fxhelper.misc.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class MsgSubsParam {
    @NotBlank
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
