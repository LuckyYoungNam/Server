package org.example.youngnam.domain.post.service;

import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;

public interface PostService {
    Post savePostPreContent(Long userId, PostRequestDTO.PostPreContentSaveDTO requestDTO);
    PostResponseDTO.PostGptContentSaveDTO savePostGptContent(String gptResult, Post post);
    PostResponseDTO.PostFinalContentSaveDTO savePostFinalContent(Long userId, PostRequestDTO.PostFinalContentSaveDTO requestDTO);
}
