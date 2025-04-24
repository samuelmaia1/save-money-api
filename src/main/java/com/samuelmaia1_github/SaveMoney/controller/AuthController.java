package com.samuelmaia1_github.SaveMoney.controller;

import com.samuelmaia1_github.SaveMoney.dto.LoginDto;
import com.samuelmaia1_github.SaveMoney.dto.UserResponseDto;
import com.samuelmaia1_github.SaveMoney.httpResponse.LoginResponse;
import com.samuelmaia1_github.SaveMoney.model.User;
import com.samuelmaia1_github.SaveMoney.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto login) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.validateLogin(login));
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponseDto> getUserByToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        System.out.println(token);
        return ResponseEntity.ok(service.getUserByJWT(token));
    }
}
