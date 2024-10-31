package org.example.youngnam.domain.post.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.example.youngnam.domain.post.service.PostService;
import org.example.youngnam.domain.post.vo.PostFindOneVO;
import org.example.youngnam.global.gpt.service.GptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PostFacade {
    private final PostService postService;
    private final GptService gptService;

    @Transactional
    public PostResponseDTO.PostGptContentSaveDTO savePostAndGenerateGptContent(final Long userId, PostRequestDTO.PostPreContentSaveDTO requestDTO) {
        Post savedPost = postService.savePostPreContent(userId, requestDTO);

        String gptContent = gptService.generateGptContent(savedPost.getPostGptContent());
        return postService.savePostGptContent(gptContent, savedPost);
    }

    @Transactional
    public PostResponseDTO.PostFinalContentSaveDTO savePostFinalContent(final Long userId, PostRequestDTO.PostFinalContentSaveDTO requestDTO) {
        return postService.savePostFinalContent(userId, requestDTO);
    }

    public Page<PostFindOneVO> findAll(final Long userId, Pageable pageable) {
        return postService.findAll(userId, pageable);
    }

    public PostResponseDTO.PostFindDetailDTO findDetail(final Long userId, Long postId) {
        return postService.findDetail(userId, postId);
    }
}