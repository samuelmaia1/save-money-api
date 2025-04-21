package com.samuelmaia1_github.SaveMoney.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ExpenseDto(
        @NotNull String receiver,
        @NotNull String category,
        @NotNull Double value,
        @NotNull Boolean isCurrent,
        @NotNull String description,
        @NotNull @PastOrPresent @JsonFormat LocalDate date
) {
}
