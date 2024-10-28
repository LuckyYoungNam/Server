package org.example.youngnam.domain.image.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.youngnam.global.base.BaseTimeEntity;

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

    /** 원본 **/
    private String imagePreUrl;
    private String imagePrePath;
    private String imagePreFileName;
    private double imagePreWidth;
    private double imagePreHeight;

    /** 결과 **/
    private String imageResultUrl;
    private String imageResultPath;
    private String imageResultFileName;
    private double imageResultWidth;
    private double imageResultHeight;

    /** thumbnail **/
    private String thumbnailUrl;
    private String thumbnailPath;
    private String thumbnailPathFileName;
    private double thumbnailWidth;
    private double thumbnailHeight;
}
