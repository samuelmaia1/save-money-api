package com.samuelmaia1_github.SaveMoney.controller;

import com.samuelmaia1_github.SaveMoney.dto.LoginDto;
import com.samuelmaia1_github.SaveMoney.httpResponse.LoginResponse;
import com.samuelmaia1_github.SaveMoney.service.TokenService;
import com.samuelmaia1_github.SaveMoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto login) {
        System.out.println(login.email());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.validateLogin(login));
    }
}
