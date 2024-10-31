package org.example.youngnam.domain.image.repository;

import org.example.youngnam.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    boolean existsByImageIdAndUserId(Long imageId, Long userId);
}
