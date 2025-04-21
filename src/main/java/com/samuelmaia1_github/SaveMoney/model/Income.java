package com.samuelmaia1_github.SaveMoney.model;

import com.samuelmaia1_github.SaveMoney.dto.NewIncomeDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("INCOME")
public class Income extends Transaction{

    @NotNull
    @Size(max = 100)
    private String source;

    public Income (NewIncomeDto data) {
        super (data.value(), data.isCurrent(), data.description(), data.date(), "income");
        this.source = data.source();
    }
}
