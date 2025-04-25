package com.samuelmaia1_github.SaveMoney.model;

import com.samuelmaia1_github.SaveMoney.dto.TransactionDto;
import com.samuelmaia1_github.SaveMoney.dto.TransactionRequestDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("INCOME")
public class Income extends Transaction{

    @NotNull
    @Size(max = 100)
    private String source;

    public Income() {}

    public Income(TransactionRequestDto data) {
        super(data.getValue(), data.getDescription(), data.getDate(), data.getTitle(), data.getCategory());
        this.source = data.getSource();
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
                this.getSource(),
                this.getCategory(),
                this.getTitle()
        );
    }
}
