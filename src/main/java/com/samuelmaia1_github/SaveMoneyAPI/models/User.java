package com.samuelmaia1_github.SaveMoneyAPI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class User {
    @Id
    private String cpf;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    private String cep;

    private String street;

    private String city;

    private String neighborhood;

    private String uf;

    private Date registerDate;

    private List<Transaction> transactions;

    private List<Investment> investments;
}
