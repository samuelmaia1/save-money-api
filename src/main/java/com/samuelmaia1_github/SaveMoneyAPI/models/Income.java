package com.samuelmaia1_github.SaveMoneyAPI.models;

import com.samuelmaia1_github.SaveMoneyAPI.dtos.IncomeDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("INCOME")
@Getter
@Setter
@NoArgsConstructor
public class Income extends Transaction{
    private String source;

    public Income(IncomeDto data){
        super(data.amount(), data.recurring(), data.description());
        this.source = data.source();
    }
}