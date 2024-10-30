package org.example.youngnam.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND_USER(HttpStatus.NOT_FOUND,"찾을 수 없는 회원입니다."),
    NOT_FOUND_POST(HttpStatus.NOT_FOUND,"찾을 수 없는 홍보글입니다."),

    EXPIRED_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "액세스 토큰이 만료되었습니다. 재발급 받아주세요."),
    UNSUPPORTED_TOKEN_TYPE(HttpStatus.UNAUTHORIZED,  "잘못된 토큰 형식입니다."),
    MALFORMED_TOKEN(HttpStatus.UNAUTHORIZED,  "잘못된 토큰 구조입니다."),
    INVALID_SIGNATURE_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 토큰 서명입니다."),
    TOKEN_SUBJECT_NOT_NUMERIC_STRING(HttpStatus.UNAUTHORIZED, "토큰의 subject가 숫자 문자열이 아닙니다."),
    BAD_KAKAO_REQUEST(HttpStatus.BAD_REQUEST, "카카오 로그인 통신에 실패하였습니다."),


    BAD_REQUEST(HttpStatus.BAD_REQUEST,"잘못된 요청입니다."),


    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "대상을 찾을 수 없습니다."),


    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "리소스 접근 권한이 없습니다."),


    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다."),



    ;

    private final HttpStatus status;
    private final String message;
}
