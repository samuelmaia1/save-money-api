package com.samuelmaia1_github.SaveMoneyAPI.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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

    private LocalDate registerDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();
}
