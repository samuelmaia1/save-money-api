package com.samuelmaia1_github.SaveMoney.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "transaction")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Double value;

    private String category;

    private Boolean isCurrent;

    private String description;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
