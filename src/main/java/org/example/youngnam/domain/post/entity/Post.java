package org.example.youngnam.domain.post.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.youngnam.global.base.BaseTimeEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String postPreContent; // 사용자가 등록한 내용
    private String postResultContent; // 앱을 통해 변경한 후 내용
    private long userId;

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;
}
