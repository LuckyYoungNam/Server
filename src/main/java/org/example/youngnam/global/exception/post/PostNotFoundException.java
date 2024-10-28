package org.example.youngnam.global.exception.post;

import lombok.Getter;
import org.example.youngnam.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class PostNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;
    public PostNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
