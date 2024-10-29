package org.example.youngnam.domain.post.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.entity.Post;
import org.example.youngnam.domain.post.mapper.PostMapper;
import org.example.youngnam.domain.post.service.PostService;
import org.example.youngnam.global.gpt.service.GptService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PostFacade {
    private final PostService postService;
    private final GptService gptService;
    //    private final UserService userService;

    @Transactional
    public PostResponseDTO.PostGptContentSaveDTO savePostAndGenerateGptContent(PostRequestDTO.PostPreContentSaveDTO requestDTO) {
        Post savedPost = postService.savePostPreContent(requestDTO, 1L);

        String gptContent = "";
        return postService.savePostGptContent(gptContent, savedPost);
    }

    @Transactional
    public PostResponseDTO.PostFinalContentSaveDTO savePostFinalContent(PostRequestDTO.PostFinalContentSaveDTO requestDTO) {
        return postService.savePostFinalContent(requestDTO, 1L);
    }
}