package org.example.youngnam.domain.post.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class PostRequestDTO {
    @Getter
    @AllArgsConstructor
    public static class PostPreContentSaveDTO {
        private String postPreContent;
    }

    @Getter
    @AllArgsConstructor
    public static class PostFinalContentSaveDTO {
        private Long postId;
        private String postFinalContent;
    }
}
