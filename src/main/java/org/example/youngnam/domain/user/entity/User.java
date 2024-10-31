package org.example.youngnam.domain.user.entity;

import io.micrometer.core.annotation.Counted;
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
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "social_id")
    private String socialId;

    @Column(name = "business_name")
    private String businessName; //상호명

    @Column(name = "business_location")
    private String businessLocation; //장소

    @Column(name = "business_address")
    private String businessAddress; //주소

    public static User create(final String socialId) {
        return User.builder()
                .socialId(socialId)
                .build();
    }

}
