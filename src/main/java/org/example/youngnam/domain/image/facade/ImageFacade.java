package org.example.youngnam.domain.image.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.image.dto.response.ImageResponseDTO;
import org.example.youngnam.domain.image.service.ImageService;
import org.example.youngnam.domain.user.service.AuthService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ImageFacade {
    private final ImageService imageService;

    // 초기 이미지 업로드 및 썸네일 저장
    @Transactional
    public ImageResponseDTO.ImagePreUrlSaveDTO uploadAndResizePreImage(final Long userId, MultipartFile preImage) throws IOException {
        return imageService.uploadAndResizeAndSavePreImage(userId, preImage);
    }

    // 최종 커스텀된 이미지 썸네일 저장
    @Transactional
    public ImageResponseDTO.ImageFinalUrlSaveDTO uploadAndResizeFinalImage(final Long userId, Long imageId, MultipartFile finalImage) throws IOException {
        return imageService.uploadAndResizeAndSaveFinalImage(userId, imageId, finalImage);
    }
}
