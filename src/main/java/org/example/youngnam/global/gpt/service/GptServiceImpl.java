package org.example.youngnam.global.gpt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class GptServiceImpl implements GptService {
    @Override
    public String generateContent(String originalContent) {
        return "";
    }
}
