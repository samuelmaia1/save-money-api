package com.samuelmaia1_github.SaveMoney.model;

import com.samuelmaia1_github.SaveMoney.dto.ExpenseDto;
import com.samuelmaia1_github.SaveMoney.dto.TransactionDto;
import com.samuelmaia1_github.SaveMoney.dto.TransactionRequestDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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

    public Expense() {}

    public Expense(ExpenseDto data) {
        super (data.value(), data.isCurrent(), data.description(), data.date());
        this.category = data.category();
        this.receiver = data.receiver();
    }

    public Expense(TransactionRequestDto data) {
        super(data.getValue(), data.getCurrent(), data.getDescription(), data.getDate());
        this.category = data.getCategory();
        this.receiver = data.getReceiver();
    }

    public @NotNull @Size(max = 50) String getCategory() {
        return category;
    }

    public @NotNull @Size(max = 100) String getReceiver() {
        return receiver;
    }

    @Override
    public TransactionDto toDto() {
        return new TransactionDto(
                this.getId(),
                "expense",
                this.getValue(),
                this.getDate(),
                this.getDescription(),
                this.getIsCurrent(),
                this.getReceiver(),
                this.getCategory()
        );
    }

}
