package org.example.youngnam.global.exception;

public class GptException extends YoungnamException {
    public GptException() {
        super(ErrorCode.GPT_SERVICE_ERROR);
    }
    public GptException(final ErrorCode errorCode) {
        super(errorCode);
    }
}
