package com.samuelmaia1_github.SaveMoneyAPI.models;

import com.samuelmaia1_github.SaveMoneyAPI.dtos.UserDto;
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public User() {}

    public User(UserDto data) {
        this.cpf = data.getCpf();
        this.name = data.getName();
        this.email = data.getEmail();
        this.password = data.getPassword();
    }
}
