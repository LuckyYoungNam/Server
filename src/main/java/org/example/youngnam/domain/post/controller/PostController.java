package org.example.youngnam.domain.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.auth.resolver.UserId;
import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.facade.PostFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member/post")
@Tag(name = "Post", description = "홍보글 관련 API")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostFacade postFacade;

    @PostMapping("/save-pre")
    @Operation(summary = "초기 홍보글 저장 후 반환", description = "초기 홍보글을 저장한 후 Gpt를 통해 홍보글 변환 후 반환한다.")
    public ResponseEntity<PostResponseDTO.PostGptContentSaveDTO> savePreContent(@UserId final Long userId, @RequestBody final PostRequestDTO.PostPreContentSaveDTO requestDTO)  {
        return ResponseEntity.ok().body(postFacade.savePostAndGenerateGptContent(userId, requestDTO));
    }

    @PostMapping("/save-final")
    @Operation(summary = "최종 홍보글 저장", description = "최종 홍보글을 저장한다.")
    public ResponseEntity<PostResponseDTO.PostFinalContentSaveDTO> saveFinalContent(@UserId final Long userId, @RequestBody final PostRequestDTO.PostFinalContentSaveDTO requestDTO) {
        return ResponseEntity.ok().body(postFacade.savePostFinalContent(userId, requestDTO));
    }
}
