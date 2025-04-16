package com.samuelmaia1_github.SaveMoneyAPI.services;


import com.samuelmaia1_github.SaveMoneyAPI.dtos.UserDto;
import com.samuelmaia1_github.SaveMoneyAPI.models.User;
import com.samuelmaia1_github.SaveMoneyAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User newUser(UserDto data) {
        if (!(repository.existsByCpf(data.getCpf()) || repository.existsByEmail(data.getEmail()))) {
            return repository.save(new User(data));
        }
        throw new RuntimeException("Usuário com CPF ou Email já cadastrado");
    }
}
