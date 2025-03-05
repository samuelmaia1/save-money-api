package com.samuelmaia1_github.SaveMoneyAPI.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EXPENSE")
public class Expense extends Transaction{
    private String category;
    private String receiver;
}
