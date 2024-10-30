package org.example.youngnam.external.feign.kakao.dto;

public record KakaoAccessTokenInfoRes(
        Long id,
        Integer expiresInMillis,
        Integer expires_in,
        Integer app_id,
        Integer appId
) {
}
