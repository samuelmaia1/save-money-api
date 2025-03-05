package com.samuelmaia1_github.SaveMoneyAPI.models;

import com.samuelmaia1_github.SaveMoneyAPI.dtos.ExpenseDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("EXPENSE")
@Getter
@Setter
@NoArgsConstructor
public class Expense extends Transaction{
    private String category;
    private String receiver;

    public Expense(ExpenseDto data){
        super(data.amount(), data.recurring(), data.description());
        this.category = data.category();
        this.receiver = data.receiver();
    }
}
