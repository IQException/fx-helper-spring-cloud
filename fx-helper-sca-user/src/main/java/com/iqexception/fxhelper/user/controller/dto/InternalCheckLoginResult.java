package com.iqexception.fxhelper.user.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record InternalCheckLoginResult(@Positive @NotNull Long userId, @NotBlank String openId) {
}
