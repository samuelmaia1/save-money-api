package com.samuelmaia1_github.SaveMoney.model;

import com.samuelmaia1_github.SaveMoney.dto.NewExpenseDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@DiscriminatorValue("EXPENSE")
@Getter
@Setter
public class Expense extends Transaction {

    @NotNull
    @Size(max = 50)
    private String category;

    @NotNull
    @Size(max = 100)
    private String receiver;

    public Expense(NewExpenseDto data) {
        super (data.value(), data.isCurrent(), data.description(), data.date(), "outcome");
        this.category = data.category();
        this.receiver = data.receiver();
    }

}
