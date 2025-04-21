package com.samuelmaia1_github.SaveMoney.httpResponse;

import com.samuelmaia1_github.SaveMoney.dto.UserResponseDto;

public class LoginResponse {
    private Boolean success;
    private UserResponseDto user;
    private String token;



    public LoginResponse(Boolean success, UserResponseDto user, String token) {
        this.success = success;
        this.user = user;
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public UserResponseDto getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}
