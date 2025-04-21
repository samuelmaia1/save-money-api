package com.samuelmaia1_github.SaveMoney.service;

import com.samuelmaia1_github.SaveMoney.dto.LoginDto;
import com.samuelmaia1_github.SaveMoney.dto.UserRequestDto;
import com.samuelmaia1_github.SaveMoney.dto.UserResponseDto;
import com.samuelmaia1_github.SaveMoney.exception.InvalidCredentialsException;
import com.samuelmaia1_github.SaveMoney.exception.UserAlreadyExistsException;
import com.samuelmaia1_github.SaveMoney.exception.UserNotFoundException;
import com.samuelmaia1_github.SaveMoney.httpResponse.LoginResponse;
import com.samuelmaia1_github.SaveMoney.model.User;
import com.samuelmaia1_github.SaveMoney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private DtoService dtoService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder encoder;

    public User addUser(UserRequestDto data) {
        if (repository.existsByEmail(data.getEmail()))
            throw new UserAlreadyExistsException("E-mail já cadastrado");
        User user = new User(data);
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public UserResponseDto toDto(User user) {
        return dtoService.convertToUserDto(user);
    }

    public UserResponseDto getUserById(String id) {
        Optional<User> user = repository.findById(id);
        return user.isPresent() ? dtoService.convertToUserDto(user.get()) : null;
    }

    public LoginResponse validateLogin(LoginDto loginData) {
        System.out.println(loginData.email());
        User user = repository.findByEmail(loginData.email());

        if (user == null)
            throw new UserNotFoundException("Usuário com este e-mail não encontrado.");

        if (!encoder.matches(loginData.password(), user.getPassword()))
            throw new InvalidCredentialsException("Senha inválida.");

        return new LoginResponse(true, this.toDto(user), tokenService.generateToken(user));
    }

    public List<UserResponseDto> getAllUsers() {
        return repository
                .findAll()
                .stream()
                .map(user -> dtoService.convertToUserDto(user))
                .toList();
    }

}
