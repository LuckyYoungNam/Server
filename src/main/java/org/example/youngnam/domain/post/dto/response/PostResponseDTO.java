package org.example.youngnam.domain.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class PostResponseDTO {
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
