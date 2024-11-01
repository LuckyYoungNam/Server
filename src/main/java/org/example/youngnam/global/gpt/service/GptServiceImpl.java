package org.example.youngnam.global.gpt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.youngnam.domain.user.entity.User;
import org.example.youngnam.global.exception.exceptions.GptException;
import org.example.youngnam.global.gpt.dto.request.GptRequestDTO;
import org.example.youngnam.global.gpt.dto.response.GptResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;

import static org.example.youngnam.global.exception.ErrorCode.GPT_SERVICE_ERROR;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class GptServiceImpl implements GptService {
    private final WebClient gptWebClient;

    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;

    private static final int RETRY_ATTEMPTS = 3;
    private static final int RETRY_DELAY_SECONDS = 5;

    private static final String PROMPT = "사용자가 작성한 짧은 멘트를 참고하여, 최대한 길게 친근하고 귀여운 블로그 스타일로 길이감 있게 확장해 주세요. " +
            "이모티콘을 적절히 섞어 가게의 따뜻하고 포근한 분위기를 표현해 주세요. " +
            "고객들이 편안하고 친근한 느낌을 받을 수 있도록 문장과 표현을 세심하게 다듬어 주세요." +
            "정화한 정보를 전달할 수 있게 도와주세요. ";

    @Override
    @Transactional
    public String generateGptContent(User user, String userContent) {
        String completePrompt = PROMPT + userContent;

        GptRequestDTO.GptCompletionDTO requestDTO = new GptRequestDTO.GptCompletionDTO(model,
                List.of(new GptRequestDTO.GptMessageDTO("user", completePrompt)));

        try {
            return gptWebClient.post()
                    .uri(apiUrl)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(requestDTO)
                    .retrieve()
                    .bodyToMono(GptResponseDTO.class)
                    .retryWhen(Retry.fixedDelay(RETRY_ATTEMPTS, Duration.ofSeconds(RETRY_DELAY_SECONDS)))
                    .doOnError(e -> log.error("GPT 요청 중 오류 발생: {}", e.getMessage()))
                    .map(response -> response.choices().get(0).message().content())
                    .block();
        } catch (Exception e) {
            throw new GptException(GPT_SERVICE_ERROR);
        }
    }
}