package com.samuelmaia1_github.SaveMoney.service;

import com.samuelmaia1_github.SaveMoney.dto.UserRequestDto;
import com.samuelmaia1_github.SaveMoney.dto.UserResponseDto;
import com.samuelmaia1_github.SaveMoney.model.User;
import com.samuelmaia1_github.SaveMoney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private DtoService dtoService;

    public User addUser(UserRequestDto data) {
        return repository.save(new User(data));
    }

    public UserResponseDto getUserById(String id) {
        Optional<User> user = repository.findById(id);
        return user.isPresent() ? dtoService.convertToUserDto(user.get()) : null;
    }

    public List<UserResponseDto> getAllUsers() {
        return repository
                .findAll()
                .stream()
                .map(user -> dtoService.convertToUserDto(user))
                .toList();
    }

}
