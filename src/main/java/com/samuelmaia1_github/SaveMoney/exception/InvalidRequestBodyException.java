package com.samuelmaia1_github.SaveMoney.exception;

public class InvalidRequestBodyException extends RuntimeException{
    public InvalidRequestBodyException() {
        super("Corpo da requisição inválido.");
    }

    public InvalidRequestBodyException(String message) {
        super(message);
    }
}
