package com.samuelmaia1_github.SaveMoney.model;

import com.samuelmaia1_github.SaveMoney.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public User() {}

    public User(UserRequestDto data) {
        this.name = data.getName();
        this.lastName = data.getLastName();
        this.email = data.getEmail();
        this.password = data.getPassword();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
