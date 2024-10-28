package org.example.youngnam.global.exception;

import lombok.Getter;

@Getter
public class ApiErrorResponse {
    private ErrorCode errorCode;
    private int errorStatus;
    private String message;

    public ApiErrorResponse(ErrorCode errorCode, int errorStatus, String message) {
        super();
        this.errorCode = errorCode;
        this.errorStatus = errorStatus;
        this.message = message;
    }
}