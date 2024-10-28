package org.example.youngnam.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND_USER(400,"찾을 수 없는 회원입니다."),
    NOT_FOUND_POST(400,"찾을 수 없는 홍보글입니다.");

    private final int status;
    private final String message;
}
