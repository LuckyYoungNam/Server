package org.example.youngnam.domain.post.dto.response;


import java.time.LocalDateTime;

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
            String postFinalContent
    ) {
    }

//    public record PostFindOneDTO(
//            Long postId,
//            LocalDateTime postDate
//    ) {
//    }

    public record PostFindDetailDTO(
            Long postId,
            String postFinalContent
    ) {
    }
}