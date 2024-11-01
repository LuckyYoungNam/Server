package org.example.youngnam.global.gpt.service;


import org.example.youngnam.domain.user.entity.User;

public interface GptService {
    String generateGptContent(final User user, String userContent);
}
