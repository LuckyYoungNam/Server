package org.example.youngnam.global.exception;

import org.example.youngnam.global.exception.post.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleException(PostNotFoundException ex){
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        ex.getErrorCode(),
                        ex.getErrorCode().getStatus(),
                        ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
