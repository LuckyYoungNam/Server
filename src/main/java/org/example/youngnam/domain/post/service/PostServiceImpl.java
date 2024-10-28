package org.example.youngnam.domain.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.example.youngnam.domain.post.mapper.PostMapper;
import org.example.youngnam.domain.post.repository.PostRepository;
import org.example.youngnam.global.exception.post.PostNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.example.youngnam.global.exception.ErrorCode.NOT_FOUND_POST;

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
    public PostResponseDTO.PostGptContentSaveDTO savePostGptContent(String gptResult, Post post) {
        post.savePostGptContent(gptResult);
        return postMapper.toPostGptContentSaveDTO(post);
    }

    @Override
    @Transactional
    public PostResponseDTO.PostFinalContentSaveDTO savePostFinalContent(Long postId, String gptResult) {

        return null;
    }


    @Override
    public Post getPostByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(NOT_FOUND_POST));
    }
}
