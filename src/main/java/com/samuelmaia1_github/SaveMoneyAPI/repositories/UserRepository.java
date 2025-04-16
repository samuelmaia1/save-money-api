package com.samuelmaia1_github.SaveMoneyAPI.repositories;

import com.samuelmaia1_github.SaveMoneyAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
