package org.example.youngnam.domain.image.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.youngnam.global.base.BaseTimeEntity;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String imageFormat;
    private long userId;
    @Enumerated(EnumType.STRING)
    private ImageStatus imageStatus;


    /** 초기 이미지의 썸네일 **/
    private String preThumbnailUrl;
    private String preThumbnailPath;
    private String preThumbnailFileName;
    private double preThumbnailWidth;
    private double preThumbnailHeight;

    /** 최종 커스텀된 이미지의 썸네일 **/
    private String finalThumbnailUrl;
    private String finalThumbnailPath;
    private String finalThumbnailFileName;
    private double finalThumbnailWidth;
    private double finalThumbnailHeight;

    public static Image from(MultipartFile preImage, String preThumbnailUrl, BufferedImage preThumbnail, Long userId) {
        return Image.builder()
                .userId(userId)
                .imageFormat(preImage.getContentType())
                .preThumbnailUrl(preThumbnailUrl)
                .preThumbnailWidth(preThumbnail.getWidth())
                .preThumbnailHeight(preThumbnail.getHeight())
                .imageStatus(ImageStatus.ACTIVE)
                .build();
    }

    public void updateFinalThumbnail(String finalThumbnailUrl, BufferedImage finalThumbnail) {
        this.finalThumbnailUrl = finalThumbnailUrl;
        this.finalThumbnailWidth = finalThumbnail.getWidth();
        this.finalThumbnailHeight = finalThumbnail.getHeight();
    }
}
