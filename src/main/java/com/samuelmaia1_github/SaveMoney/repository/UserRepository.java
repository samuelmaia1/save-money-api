package com.samuelmaia1_github.SaveMoney.repository;

import com.samuelmaia1_github.SaveMoney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
