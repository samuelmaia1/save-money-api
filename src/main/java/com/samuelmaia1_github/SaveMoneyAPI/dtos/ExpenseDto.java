package com.samuelmaia1_github.SaveMoneyAPI.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public record ExpenseDto(
        Double amount,
        Boolean recurring,
        LocalDate date,
        String description,
        String userId,
        String category,
        String receiver
) {
}
