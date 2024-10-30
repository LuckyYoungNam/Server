package org.example.youngnam.domain.image.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.image.dto.response.ImageResponseDTO;
import org.example.youngnam.domain.image.facade.ImageFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/member/image")
@Tag(name = "Image", description = "홍보사진 관련 API")
@RequiredArgsConstructor
@Slf4j
public class ImageController {
    private final ImageFacade imageFacade;

    @PostMapping("/save-pre")
    public ResponseEntity<ImageResponseDTO.ImagePreUrlSaveDTO> uploadPreImage(@RequestParam("imagePreFile") MultipartFile imagePreFile) throws IOException, IOException {
        return ResponseEntity.ok(imageFacade.uploadAndResizePreImage(imagePreFile));
    }


    @PostMapping("/save-final")
    public ResponseEntity<ImageResponseDTO.ImageFinalUrlSaveDTO> uploadFinalImage(@RequestParam("imageFinalFile") MultipartFile imageFinalFile, @RequestParam("imageId") Long imageId) throws IOException {
        return ResponseEntity.ok(imageFacade.uploadAndResizeFinalImage(imageFinalFile, imageId));
    }

}
