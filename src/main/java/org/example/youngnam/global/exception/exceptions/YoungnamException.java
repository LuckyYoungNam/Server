package org.example.youngnam.global.exception.exceptions;

import lombok.Getter;
import org.example.youngnam.global.exception.ErrorCode;

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
