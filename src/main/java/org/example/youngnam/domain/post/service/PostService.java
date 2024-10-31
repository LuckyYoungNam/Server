package org.example.youngnam.domain.post.service;

import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.example.youngnam.domain.post.vo.PostFindOneVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Post savePostPreContent(final Long userId, PostRequestDTO.PostPreContentSaveDTO requestDTO);
    PostResponseDTO.PostGptContentSaveDTO savePostGptContent(String gptResult, Post post);
    PostResponseDTO.PostFinalContentSaveDTO savePostFinalContent(final Long userId, PostRequestDTO.PostFinalContentSaveDTO requestDTO);
    Page<PostFindOneVO> findAll(final Long userId, Pageable pageable);
    PostResponseDTO.PostFindDetailDTO findDetail(final Long userId, Long postId);
}