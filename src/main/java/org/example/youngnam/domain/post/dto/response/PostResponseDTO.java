package org.example.youngnam.domain.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.youngnam.domain.post.entity.PostStatus;

public class PostResponseDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class PostPreContentSaveDTO {
        private Long postId;
        private String postPreContent;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PostGptContentSaveDTO {
        private Long postId;
        private String postGptContent;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PostFinalContentSaveDTO {
        private Long postId;
        private String postPreContent;
        private String postFinalContent;
        private Long userId;
    }
}
