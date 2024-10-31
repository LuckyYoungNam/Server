package org.example.youngnam.global.gpt.dto.response;

import org.example.youngnam.global.gpt.dto.request.GptRequestDTO;
import java.util.List;

public record GptResponseDTO(List<Choice> choices) {
    public record Choice(int index, GptRequestDTO.GptMessageDTO message) {
    }
}