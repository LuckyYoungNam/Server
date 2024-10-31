package org.example.youngnam.domain.image.dto.request;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class ImageRequestDTO {
    public record ImageFinalFileSaveDTO(
            @NotNull Long userId,
            @NotNull MultipartFile imageFinalFile
    ) {
    }
}
