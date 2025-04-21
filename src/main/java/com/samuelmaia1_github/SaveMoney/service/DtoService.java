package com.samuelmaia1_github.SaveMoney.service;

import com.samuelmaia1_github.SaveMoney.dto.TransactionDto;
import com.samuelmaia1_github.SaveMoney.dto.UserResponseDto;
import com.samuelmaia1_github.SaveMoney.model.Transaction;
import com.samuelmaia1_github.SaveMoney.model.User;
import org.springframework.stereotype.Service;

@Service
public class DtoService {

    public UserResponseDto convertToUserDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getTransactions().stream().map(this::convertToTransactionDto).toList(),
                user.getEmail());
    }

    public TransactionDto convertToTransactionDto(Transaction transaction) {
        return transaction.toDto();
    }
}
