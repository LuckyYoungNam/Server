package org.example.youngnam.domain.post.dto.request;

import jakarta.validation.constraints.NotNull;

public class PostRequestDTO {
    public record PostPreContentSaveDTO(
           @NotNull String postPreContent
    ) {
    }
    public record PostFinalContentSaveDTO(
            @NotNull Long postId,
            @NotNull String postFinalContent
    ) {
    }
}
