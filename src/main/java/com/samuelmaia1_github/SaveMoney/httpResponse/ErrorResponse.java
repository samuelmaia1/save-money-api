package com.samuelmaia1_github.SaveMoney.httpResponse;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime time;
    private String error;
    private String message;
    private String path;
    private Integer status;

    public ErrorResponse() {}

    public ErrorResponse(LocalDateTime time, String error, String message, String path, Integer status) {
        this.time = time;
        this.error = error;
        this.message = message;
        this.path = path;
        this.status = status;
    }
}
