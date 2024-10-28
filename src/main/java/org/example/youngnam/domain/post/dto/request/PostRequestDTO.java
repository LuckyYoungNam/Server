package org.example.youngnam.domain.post.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.youngnam.domain.post.entity.PostStatus;

public class PostRequestDTO {
    @Getter
    @AllArgsConstructor
    public static class PostPreContentSaveDTO {
        private String postPreContent;
    }

    @Getter
    @AllArgsConstructor
    public static class PostResultContentSaveDTO {
        private Long postId;
        private String postResultContent;
        private long userId;
    }
}
