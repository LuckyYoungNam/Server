package org.example.youngnam.global.exception;

import org.example.youngnam.global.exception.exceptions.YoungnamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

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

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiErrorResponse> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        ApiErrorResponse response = ApiErrorResponse.of(ErrorCode.FILE_SIZE_EXCEEDED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
