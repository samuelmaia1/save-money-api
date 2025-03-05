package com.samuelmaia1_github.SaveMoneyAPI.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "transactions")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Double amount;

    private Boolean isRecurring;

    private Date date;

    private String description;
}
