package org.example.youngnam.domain.image.service;

import org.example.youngnam.domain.image.dto.response.ImageResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ImageResponseDTO.ImagePreUrlSaveDTO uploadAndResizeAndSavePreImage(MultipartFile preImage, Long userId) throws IOException;

    ImageResponseDTO.ImageFinalUrlSaveDTO uploadAndResizeAndSaveFinalImage(MultipartFile finalImage, Long imageId, Long userId) throws IOException;
}
