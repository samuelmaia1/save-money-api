package com.samuelmaia1_github.SaveMoney.service;

import com.samuelmaia1_github.SaveMoney.dto.LoginDto;
import com.samuelmaia1_github.SaveMoney.dto.UserResponseDto;
import com.samuelmaia1_github.SaveMoney.exception.InvalidCredentialsException;
import com.samuelmaia1_github.SaveMoney.exception.UserNotFoundException;
import com.samuelmaia1_github.SaveMoney.httpResponse.LoginResponse;
import com.samuelmaia1_github.SaveMoney.model.User;
import com.samuelmaia1_github.SaveMoney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private DtoService dtoService;

    public LoginResponse validateLogin(LoginDto loginData) {
        System.out.println(loginData.email());
        Optional<User> optionalUser = repository.findByEmail(loginData.email());

        if (optionalUser.isEmpty())
            throw new UserNotFoundException("Usuário com este e-mail não encontrado.");

        User user = optionalUser.get();

        if (!encoder.matches(loginData.password(), user.getPassword()))
            throw new InvalidCredentialsException("Senha inválida.");

        return new LoginResponse(true, dtoService.convertToUserDto(user), tokenService.generateToken(user));
    }

    public UserResponseDto getUserByJWT(String token) {
        String subject = tokenService.validateToken(token);
        Optional<User> optionalUser = repository.findByEmail(subject);

        if (optionalUser.isEmpty())
            throw new UserNotFoundException("Usuário com o e-mail do token não existe");

        return dtoService.convertToUserDto(optionalUser.get());
    }
}
