package com.samuelmaia1_github.SaveMoney.service;

import com.samuelmaia1_github.SaveMoney.dto.*;
import com.samuelmaia1_github.SaveMoney.exception.InvalidCredentialsException;
import com.samuelmaia1_github.SaveMoney.exception.UserAlreadyExistsException;
import com.samuelmaia1_github.SaveMoney.exception.UserNotFoundException;
import com.samuelmaia1_github.SaveMoney.httpResponse.LoginResponse;
import com.samuelmaia1_github.SaveMoney.model.Expense;
import com.samuelmaia1_github.SaveMoney.model.Income;
import com.samuelmaia1_github.SaveMoney.model.Transaction;
import com.samuelmaia1_github.SaveMoney.model.User;
import com.samuelmaia1_github.SaveMoney.repository.TransactionRepository;
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
    private TransactionRepository transactionRepository;

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
        User user = repository
                    .findById(id)
                    .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
        return dtoService.convertToUserDto(user);
    }

    public User getUserEntityById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
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

    public TransactionDto addTransaction(TransactionRequestDto data, String userId) {
        data.validate();

        User user = getUserEntityById(userId);

        Transaction transaction = data.isExpense() ? new Expense(data) : new Income(data);

        transaction.setUser(user);
        user.getTransactions().add(transaction);
        repository.save(user);
        transactionRepository.save(transaction);

        return transaction.toDto();
    }

}
