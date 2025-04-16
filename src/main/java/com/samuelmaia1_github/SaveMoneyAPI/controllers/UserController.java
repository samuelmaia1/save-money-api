package com.samuelmaia1_github.SaveMoneyAPI.controllers;

import com.samuelmaia1_github.SaveMoneyAPI.dtos.LoginDto;
import com.samuelmaia1_github.SaveMoneyAPI.dtos.UserDto;
import com.samuelmaia1_github.SaveMoneyAPI.models.User;
import com.samuelmaia1_github.SaveMoneyAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    private ResponseEntity<Boolean> authLogin(@RequestBody LoginDto data) {
        return (data.email().equals("mail") && data.password().equals("senha")) ?
                ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }

    @PostMapping("/register")
    private ResponseEntity<?> newUser(@RequestBody UserDto data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(service.newUser(data));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
