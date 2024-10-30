package org.example.youngnam.domain.user.dto;

import lombok.Builder;

@Builder
public record UserLoginRes(
        String accessToken,
        String refreshToken
) {
    public static UserLoginRes of(final String accessToken, final String refreshToken) {
        return UserLoginRes.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
