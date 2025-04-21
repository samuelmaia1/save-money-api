package com.samuelmaia1_github.SaveMoney.service;

import com.samuelmaia1_github.SaveMoney.dto.UserDto;
import com.samuelmaia1_github.SaveMoney.model.User;
import com.samuelmaia1_github.SaveMoney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private DtoService dtoService;

    public UserDto getUserById(String id) {
        Optional<User> user = repository.findById(id);
        return user.isPresent() ? dtoService.convertToUserDto(user.get()) : null;
    }

}
