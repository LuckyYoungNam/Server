package org.example.youngnam.domain.user.dto;

import lombok.Builder;

@Builder
public record UserBusinessInfoRes(
        String businessName,
        String location,
        String address
) {
    public static UserBusinessInfoRes of(final String businessName,
                                         final String location,
                                         final String address) {
        return UserBusinessInfoRes.builder()
                .businessName(businessName)
                .location(location)
                .address(address)
                .build();
    }
}
