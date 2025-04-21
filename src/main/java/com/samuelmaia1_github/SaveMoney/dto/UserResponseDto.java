package com.samuelmaia1_github.SaveMoney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserResponseDto {
    private String id;
    private String name;
    private String lastName;
    private List<TransactionDto> transactions;
    private String email;
}
