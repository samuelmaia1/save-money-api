package com.samuelmaia1_github.SaveMoney.model;

import com.samuelmaia1_github.SaveMoney.dto.TransactionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "transaction")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.STRING)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Double value;

    private Boolean isCurrent;

    private String description;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Transaction(Double value, Boolean isCurrent, String description, LocalDate date) {
        this.value = value;
        this.isCurrent = isCurrent;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public Boolean getIsCurrent() {
        return isCurrent;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public abstract TransactionDto toDto();
}
