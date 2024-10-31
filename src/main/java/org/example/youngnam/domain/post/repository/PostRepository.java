package org.example.youngnam.domain.post.repository;

import feign.Param;
import org.example.youngnam.domain.post.entity.Post;
import org.example.youngnam.domain.post.vo.PostFindOneVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    boolean existsByPostIdAndUserId(Long postId, Long userId);
    @Query(value = "SELECT p.post_id AS postId, p.updated_date AS postDate " +
            "FROM post p " +
            "WHERE p.user_id = :userId AND p.post_status = :status",
            countQuery = "SELECT COUNT(*) FROM post p WHERE p.user_id = :userId AND p.post_status = :status",
            nativeQuery = true)
    Page<PostFindOneVO> findPostsByUserIdAndStatus(
            @Param("userId") Long userId,
            @Param("status") String status,
            Pageable pageable
    );
}
