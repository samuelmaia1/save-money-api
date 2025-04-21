package com.samuelmaia1_github.SaveMoney.service;

import com.samuelmaia1_github.SaveMoney.dto.TransactionDto;
import com.samuelmaia1_github.SaveMoney.dto.TransactionRequestDto;
import com.samuelmaia1_github.SaveMoney.model.Expense;
import com.samuelmaia1_github.SaveMoney.model.Income;
import com.samuelmaia1_github.SaveMoney.model.Transaction;
import com.samuelmaia1_github.SaveMoney.model.User;
import com.samuelmaia1_github.SaveMoney.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    public TransactionDto addTransaction(TransactionRequestDto data, String userId) {
        return userService.addTransaction(data, userId);
    }
}
