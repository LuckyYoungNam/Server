package org.example.youngnam.domain.user.dto;

public record UserBusinessInfoReq(
        String businessName,
        String location,
        String address
) {
}
