package org.example.youngnam.global.gpt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.youngnam.global.gpt.dto.request.GptRequestDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
// swagger 작성 필요 x
public class GptResponseDTO {
    private List<Choice> choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {
        //gpt 대화 인덱스 번호
        private int index;
        // 지피티로 부터 받은 메세지
        // 여기서 content는 유저의 prompt가 아닌 gpt로부터 받은 response
        private GptRequestDTO.GptMessageDTO message;
    }
}