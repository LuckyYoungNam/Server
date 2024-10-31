package org.example.youngnam.domain.image.mapper;

import org.example.youngnam.domain.image.dto.response.ImageResponseDTO;
import org.example.youngnam.domain.image.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    // 초기 이미지 매핑 (Pre URL)
    @Mapping(target = "ImagePreUrl", source = "preThumbnailUrl")
    ImageResponseDTO.ImagePreUrlSaveDTO toPreUrlDTO(Image image);

    // 최종 이미지 매핑 (Final URL)
    @Mapping(target = "ImagePreUrl", source = "preThumbnailUrl")
    @Mapping(target = "ImageFinalUrl", source = "finalThumbnailUrl")
    ImageResponseDTO.ImageFinalUrlSaveDTO toFinalUrlDTO(Image image);
}