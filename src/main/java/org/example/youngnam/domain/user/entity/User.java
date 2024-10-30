package org.example.youngnam.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.youngnam.global.base.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String socialId;

}
