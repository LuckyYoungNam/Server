package org.example.youngnam.global.exception;

import lombok.Getter;

@Getter
public class YoungnamException extends RuntimeException {
    private final ErrorCode errorCode;

    public YoungnamException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public YoungnamException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
