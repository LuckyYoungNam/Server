package org.example.youngnam.domain.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.example.youngnam.domain.post.mapper.PostMapper;
import org.example.youngnam.domain.post.repository.PostRepository;
import org.example.youngnam.global.exception.exceptions.EntityNotFoundException;
import org.example.youngnam.global.exception.ErrorCode;
import org.example.youngnam.global.exception.exceptions.UnauthorizedException;
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
    public Post savePostPreContent(final Long userId, PostRequestDTO.PostPreContentSaveDTO requestDTO) {
        return  postRepository.save(Post.from(requestDTO, userId));
    }

    @Override
    @Transactional
    public PostResponseDTO.PostGptContentSaveDTO savePostGptContent(String gptContent, Post post) {
        post.savePostGptContent(gptContent);
        return postMapper.toPostGptContentSaveDTO(post);
    }

    @Override
    @Transactional
    public PostResponseDTO.PostFinalContentSaveDTO savePostFinalContent(final Long userId, PostRequestDTO.PostFinalContentSaveDTO requestDTO) {
        Post findPost = getPostByPostId(requestDTO.postId());
        checkUnauthorized(requestDTO.postId(), userId);
        findPost.savePostFinalContent(requestDTO.postFinalContent());
        return postMapper.toPostFinalContentSaveDTO(findPost);
    }

    private Post getPostByPostId(final Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.NOT_FOUND_POST));
    }

    private void checkUnauthorized(final Long postId, final Long userId) {
        if (!postRepository.existsByPostIdAndUserId(postId, userId)) {
            throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_POST);
        }
    }
}
