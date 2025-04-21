package com.samuelmaia1_github.SaveMoney.controller;

import com.samuelmaia1_github.SaveMoney.dto.UserRequestDto;
import com.samuelmaia1_github.SaveMoney.dto.UserResponseDto;
import com.samuelmaia1_github.SaveMoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody UserRequestDto data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addUser(data));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok().body(service.getAllUsers());
    }
}
