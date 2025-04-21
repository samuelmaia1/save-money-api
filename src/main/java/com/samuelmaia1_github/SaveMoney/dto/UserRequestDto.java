package com.samuelmaia1_github.SaveMoney.dto;

import lombok.AllArgsConstructor;

public class UserRequestDto {
    private String name;
    private String lastName;
    private String email;
    private String password;

    public UserRequestDto() {}

    public UserRequestDto(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
