package org.example.youngnam.domain.image.service;

import org.example.youngnam.domain.image.dto.response.ImageResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ImageResponseDTO.ImagePreUrlSaveDTO uploadAndResizeAndSavePreImage(Long userId, MultipartFile preImage) throws IOException;

    ImageResponseDTO.ImageFinalUrlSaveDTO uploadAndResizeAndSaveFinalImage(Long userId, Long imageId, MultipartFile finalImage) throws IOException;
}
