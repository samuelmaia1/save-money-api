package com.samuelmaia1_github.SaveMoney.controller;

import com.samuelmaia1_github.SaveMoney.dto.TransactionDto;
import com.samuelmaia1_github.SaveMoney.dto.TransactionRequestDto;
import com.samuelmaia1_github.SaveMoney.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionsController {

    @Autowired
    private TransactionService service;

    @PostMapping("/{userId}")
    public ResponseEntity<TransactionDto> addTransaction(
            @RequestBody @Valid TransactionRequestDto data,
            @PathVariable String userId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addTransaction(data, userId));
    }

}
