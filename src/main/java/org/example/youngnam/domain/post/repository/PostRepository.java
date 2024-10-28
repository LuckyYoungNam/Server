package org.example.youngnam.domain.post.repository;

import org.example.youngnam.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
