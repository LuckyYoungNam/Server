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

    private static final String PROMPT = "홍보글을 블로그 홍보 형식으로 작성해줘: ";

    private final RestTemplate restTemplate;

    @Override
    @Transactional
    public String generatePromotionalContent(String userContent) {
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
