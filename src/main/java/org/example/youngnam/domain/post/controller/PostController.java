package org.example.youngnam.domain.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.post.dto.request.PostRequestDTO;
import org.example.youngnam.domain.post.dto.response.PostResponseDTO;
import org.example.youngnam.domain.post.facade.PostFacade;
import org.example.youngnam.domain.post.vo.PostFindOneVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Operation(summary = "초기 홍보 글 저장 후 반환", description = "초기 홍보 글을 저장한 후 Gpt를 통해 홍보글 변환 후 반환한다.")
    public ResponseEntity<PostResponseDTO.PostGptContentSaveDTO> savePreContent(@RequestBody PostRequestDTO.PostPreContentSaveDTO requestDTO)  {
        return ResponseEntity.ok().body(postFacade.savePostAndGenerateGptContent(requestDTO));
    }

    @PostMapping("/save-final")
    @Operation(summary = "최종 홍보 글 저장", description = "최종 홍보 글을 저장한다.")
    public ResponseEntity<PostResponseDTO.PostFinalContentSaveDTO> saveFinalContent(@RequestBody PostRequestDTO.PostFinalContentSaveDTO requestDTO) {
        return ResponseEntity.ok().body(postFacade.savePostFinalContent(requestDTO));
    }

    @GetMapping("/findAll")
    @Operation(summary = "이전 홍보 글 전체 조회", description = "이전 홍보 글을 전체 조회한다.")
    public Page<PostFindOneVO> findAll(Pageable pageable) {
        return postFacade.findAll(pageable);
    }

    @GetMapping("/findOne/{postId}")
    @Operation(summary = "홍보 글 조회", description = "홍보 글 조회한다.")
    public PostResponseDTO.PostFindDetailDTO findOne(@PathVariable Long postId) {
        return postFacade.findDetail(postId);
    }
}