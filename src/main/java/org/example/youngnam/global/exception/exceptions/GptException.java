package org.example.youngnam.global.exception.exceptions;

import org.example.youngnam.global.exception.ErrorCode;

public class GptException extends YoungnamException {
    public GptException() {
        super(ErrorCode.GPT_SERVICE_ERROR);
    }
    public GptException(final ErrorCode errorCode) {
        super(errorCode);
    }
}
