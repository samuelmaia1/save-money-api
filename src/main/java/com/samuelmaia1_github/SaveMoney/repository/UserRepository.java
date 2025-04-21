package com.samuelmaia1_github.SaveMoney.repository;

import com.samuelmaia1_github.SaveMoney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Boolean existsByEmail(String email);
}
