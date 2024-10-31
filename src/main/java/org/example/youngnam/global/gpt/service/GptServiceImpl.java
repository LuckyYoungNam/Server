package org.example.youngnam.global.gpt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.global.gpt.dto.request.GptRequestDTO;
import org.example.youngnam.global.gpt.dto.response.GptResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class GptServiceImpl implements GptService {
    @Value("${gpt.model}")
    private String model;
    @Value("${gpt.api.url}")
    private String apiUrl;
    @Value("${gpt.api.key}")
    private String apiKey;

    private static final String PROMPT = "“사용자가 작성한 짧은 멘트를 참고하여, 친근하고 귀여운 블로그 스타일로 길이감 있게 확장해 주세요. 이모티콘을 적절히 섞어 가게의 따뜻하고 포근한 분위기를 표현해 주세요. 고객들이 편안하고 친근한 느낌을 받을 수 있도록 문장과 표현을 세심하게 다듬어 주세요. 예를 들어, ‘따뜻한 ☕ 커피 한 잔과 함께 여유를 즐겨보세요’처럼 따뜻한 분위기와 매력을 담아 주세요.";

    private final RestTemplate restTemplate;

    @Override
    @Transactional
    public String generateGptContent(String userContent) {
        GptRequestDTO requestDTO = new GptRequestDTO(model, PROMPT + userContent);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);
        HttpEntity<GptRequestDTO> httpRequest = new HttpEntity<>(requestDTO, headers);

        try {
            ResponseEntity<GptResponseDTO> response = restTemplate.postForEntity(apiUrl, httpRequest, GptResponseDTO.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody().getGeneratedContent();
            } else {
                log.error("GPT 응답 오류: {}", response.getStatusCode());
                throw new RuntimeException("GPT 호출 실패");
            }
        } catch (Exception e) {
            log.error("GPT 호출 중 오류 발생: {}", e.getMessage());
            throw new RuntimeException("GPT 서비스 호출 중 오류 발생", e);
        }
    }
}
