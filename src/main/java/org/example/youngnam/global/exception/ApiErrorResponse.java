package org.example.youngnam.global.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PROTECTED)
public class ApiErrorResponse {
    private HttpStatus errorStatus;
    private String message;

    public static ApiErrorResponse of(final ErrorCode errorCode) {
        return ApiErrorResponse.builder()
                .errorStatus(errorCode.getStatus())
                .message(errorCode.getMessage())
                .build();
    }
}