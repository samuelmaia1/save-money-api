package com.samuelmaia1_github.SaveMoney.model;

import com.samuelmaia1_github.SaveMoney.dto.IncomeDto;
import com.samuelmaia1_github.SaveMoney.dto.TransactionDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("INCOME")
public class Income extends Transaction{

    @NotNull
    @Size(max = 100)
    private String source;

    public Income (IncomeDto data) {
        super (data.value(), data.isCurrent(), data.description(), data.date());
        this.source = data.source();
    }

    public @NotNull @Size(max = 100) String getSource() {
        return source;
    }

    @Override
    public TransactionDto toDto() {
        return new TransactionDto(
                this.getId(),
                "income",
                this.getValue(),
                this.getDate(),
                this.getDescription(),
                this.getIsCurrent(),
                this.getSource()
        );
    }
}
