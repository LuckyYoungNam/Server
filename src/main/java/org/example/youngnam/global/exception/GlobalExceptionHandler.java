package org.example.youngnam.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(YoungnamException.class)
    public ResponseEntity<ApiErrorResponse> handleDateRoadException(final YoungnamException e) {
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(ApiErrorResponse.of(e.getErrorCode()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(final IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiErrorResponse.of(ErrorCode.BAD_REQUEST));
    }
}
