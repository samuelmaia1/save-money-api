package com.samuelmaia1_github.SaveMoney.dto;

import jakarta.validation.constraints.NotNull;

public record LoginDto(@NotNull String email, @NotNull String password) {
}
