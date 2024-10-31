package org.example.youngnam.domain.post.service;

import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.example.youngnam.domain.post.vo.PostFindOneVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Post savePostPreContent(PostRequestDTO.PostPreContentSaveDTO requestDTO, Long userId);
    PostResponseDTO.PostGptContentSaveDTO savePostGptContent(String gptResult, Post post);
    PostResponseDTO.PostFinalContentSaveDTO savePostFinalContent(PostRequestDTO.PostFinalContentSaveDTO requestDto, Long userId);
    Page<PostFindOneVO> findAll(Pageable pageable, Long userId);
    PostResponseDTO.PostFindDetailDTO findDetail(Long postId, Long userId);
}
