package org.example.youngnam.domain.user.dto;

import lombok.Builder;

@Builder
public record UserBusinessInfoRes(
        String name,
        String location,
        String address
) {
    public static UserBusinessInfoRes of(final String name,
                                         final String location,
                                         final String address) {
        return UserBusinessInfoRes.builder()
                .name(name)
                .location(location)
                .address(address)
                .build();
    }
}
