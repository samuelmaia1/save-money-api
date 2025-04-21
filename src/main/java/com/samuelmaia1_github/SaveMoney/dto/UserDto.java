package com.samuelmaia1_github.SaveMoney.dto;

import com.samuelmaia1_github.SaveMoney.model.Transaction;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UserDto(
        @NotNull String id,
        @NotNull String name,
        @NotNull String lastName,
        @NotNull List<TransactionDto> transactions,
        @NotNull String email
        ) {
}
