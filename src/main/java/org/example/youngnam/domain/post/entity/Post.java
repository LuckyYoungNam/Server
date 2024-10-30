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
    @Column(name = "post_id")
    private Long postId;
    @Column(name = "post_pre_content")
    private String postPreContent; // 사용자가 등록한 내용
    @Column(name = "post_gpt_content")
    private String postGptContent; // 지피티가 반환하 내용
    @Column(name = "post_final_content")
    private String postFinalContent; // 최종 내용
    @Column(name = "user_id")
    private long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private PostStatus postStatus;

    public void savePostGptContent(String postGptContent) {
        this.postGptContent = postGptContent;
    }

    public void savePostFinalContent(String postFinalContent) {
        this.postFinalContent = postFinalContent;
    }
}
