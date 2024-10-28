package org.example.youngnam.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.youngnam.global.base.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private Long kakaoId;
    private String naverId;
    private String instagramId;
    private String daumId;

    private LocalDateTime lastLoginDate;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
