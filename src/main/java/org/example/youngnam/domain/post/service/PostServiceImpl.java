package org.example.youngnam.domain.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.example.youngnam.domain.post.mapper.PostMapper;
import org.example.youngnam.domain.post.repository.PostRepository;
import org.example.youngnam.global.exception.EntityNotFoundException;
import org.example.youngnam.global.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    @Transactional
    public Post savePostPreContent(PostRequestDTO.PostPreContentSaveDTO requestDTO, Long userId) {
        return  postRepository.save(postMapper.toEntity(requestDTO, userId));
    }

    @Override
    @Transactional
    public PostResponseDTO.PostGptContentSaveDTO savePostGptContent(String gptContent, Post post) {
        post.savePostGptContent(gptContent);
        return postMapper.toPostGptContentSaveDTO(post);
    }

    @Override
    @Transactional
    public PostResponseDTO.PostFinalContentSaveDTO savePostFinalContent(PostRequestDTO.PostFinalContentSaveDTO requestDTO, Long userId) {
        Post findPost = getPostByPostId(requestDTO.postId());
        findPost.savePostFinalContent(requestDTO.postFinalContent());
        return postMapper.toPostFinalContentSaveDTO(findPost);
    }


    @Override
    public Post getPostByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));
    }
}
