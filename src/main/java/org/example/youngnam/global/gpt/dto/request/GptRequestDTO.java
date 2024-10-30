package org.example.youngnam.global.gpt.dto.request;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class GptRequestDTO {
    private String model;
    private List<GptMessageDTO> messages;

    public GptRequestDTO(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new GptMessageDTO("user", prompt));
    }

    @Getter
    public static class GptMessageDTO {
        private String role;
        private String content;

        public GptMessageDTO(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}