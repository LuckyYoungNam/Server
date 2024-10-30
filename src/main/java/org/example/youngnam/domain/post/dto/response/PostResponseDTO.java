package org.example.youngnam.domain.post.dto.response;


public class PostResponseDTO {
    public record PostGptContentSaveDTO(
            Long postId,
            String postGptContent
    ) {
    }

    public record PostFinalContentSaveDTO(
            Long postId,
            String postPreContent,
            String postGptContent,
            String postFinalContent,
            Long userId
    ) {
    }
}