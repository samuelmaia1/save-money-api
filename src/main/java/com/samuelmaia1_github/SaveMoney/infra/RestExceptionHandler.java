package com.samuelmaia1_github.SaveMoney.infra;

import com.samuelmaia1_github.SaveMoney.exception.InvalidCredentialsException;
import com.samuelmaia1_github.SaveMoney.exception.InvalidRequestBodyException;
import com.samuelmaia1_github.SaveMoney.exception.UserAlreadyExistsException;
import com.samuelmaia1_github.SaveMoney.exception.UserNotFoundException;
import com.samuelmaia1_github.SaveMoney.httpResponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException exception, WebRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        return ResponseEntity
                .status(status)
                .body(buildErrorResponse(status, exception.getMessage(), request));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException exception, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(status)
                .body(buildErrorResponse(status, exception.getMessage(), request));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialsException exception, WebRequest request) {

        HttpStatus status = HttpStatus.UNAUTHORIZED;

        return ResponseEntity
                .status(status)
                .body(buildErrorResponse(status, exception.getMessage(), request));
    }

    @ExceptionHandler(InvalidRequestBodyException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestBody(InvalidRequestBodyException exception, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(buildErrorResponse(status, exception.getMessage(), request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(buildErrorResponse(status, exception.getMessage(), request));
    }

    private ErrorResponse buildErrorResponse(HttpStatus status, String message, WebRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                status.getReasonPhrase(),
                message,
                status.getReasonPhrase(),
                status.value()
        );
    }

    private String getExceptionPath(WebRequest request) {
        return request.getDescription(false).replace("uri=", "");
    }

}
