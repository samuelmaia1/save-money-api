package com.samuelmaia1_github.SaveMoney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String name;
    private String lastName;
    private String email;
    private String password;
}
