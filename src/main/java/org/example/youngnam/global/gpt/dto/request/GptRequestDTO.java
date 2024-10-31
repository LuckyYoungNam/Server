package org.example.youngnam.global.gpt.dto.request;

import java.util.List;

public class GptRequestDTO {

    public record GptMessageDTO(String role, String content) {
    }

    public record GptCompletionDTO(String model, List<GptMessageDTO> messages) {
    }
}