package org.example.youngnam.domain.refreshtoken.repository;

import org.example.youngnam.domain.refreshtoken.entitiy.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    void deleteByUserId(Long userId);
    Optional<RefreshToken> findRefreshTokenByToken(String token);

    void deleteRefreshTokenByUserId(final Long userId);
}
