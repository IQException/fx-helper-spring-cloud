package com.iqexception.fxhelper.user.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserLoginResult(@NotBlank String token,@NotNull Boolean newUser) {
}
