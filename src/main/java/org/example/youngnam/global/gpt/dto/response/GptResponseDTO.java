package org.example.youngnam.global.gpt.dto.response;

import lombok.Getter;

@Getter
public class GptResponseDTO {
    private String generatedContent;
    public GptResponseDTO(String generatedContent) {
        this.generatedContent = generatedContent;
    }
}
