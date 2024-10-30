package org.example.youngnam.domain.image.dto.response;

public class ImageResponseDTO {
    public record ImagePreUrlSaveDTO(
            Long imageId,
            String ImagePreUrl
    ) {
    }

    public record ImageFinalUrlSaveDTO(
            Long imageId,
            String ImagePreUrl,
            String ImageFinalUrl
    ) {
    }
}
