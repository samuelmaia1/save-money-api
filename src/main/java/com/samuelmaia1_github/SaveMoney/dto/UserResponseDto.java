package com.samuelmaia1_github.SaveMoney.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserResponseDto {
    private String id;
    private String name;
    private String lastName;
    private List<TransactionDto> transactions;
    private String email;

    public UserResponseDto(String id, String name, String lastName, List<TransactionDto> transactions, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.transactions = transactions;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public String getEmail() {
        return email;
    }
}
