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

    private static final String PROMPT_TEMPLATE = "사용자가 작성한 짧은 멘트를 참고하여, 친근하고 귀여운 블로그 스타일로 길이감 있게 확장해 주세요. " +
            "가게의 따뜻하고 포근한 분위기를 잘 살리기 위해, 다음 정보를 여러 번 자연스럽게 녹여주세요: 가게 이름은 **%s**, 위치는 **%s**이며, 주소는 **%s**입니다. " +
            "이 장소가 주는 편안함과 친근함을 이모티콘과 따뜻한 표현으로 세심하게 다듬어 고객들이 마치 이곳에 와 있는 듯한 느낌을 받을 수 있도록 해 주세요. " +
            "\n\n" +
            "가게 이름: %s\n" +
            "위치: %s\n" +
            "주소: %s";

    @Override
    @Transactional
    public String generateGptContent(final User user, String userContent) {
        String completePrompt = String.format(PROMPT_TEMPLATE, user.getBusinessName(), user.getBusinessLocation(), user.getBusinessAddress()) + userContent;

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