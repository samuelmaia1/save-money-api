package com.samuelmaia1_github.SaveMoney.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException() {
        super("Credenciais inválidas.");
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }
}