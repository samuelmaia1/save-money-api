package com.samuelmaia1_github.SaveMoney.infra;

import com.samuelmaia1_github.SaveMoney.exception.UserAlreadyExistsException;
import com.samuelmaia1_github.SaveMoney.httpResponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException exception, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.CONFLICT.getReasonPhrase(),
                        exception.getMessage(),
                        getExceptionPath(request),
                        HttpStatus.CONFLICT.value())
                );
    }

    private String getExceptionPath(WebRequest request) {
        return request.getDescription(false).replace("uri=", "");
    }

}
