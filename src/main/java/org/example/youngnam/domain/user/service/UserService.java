package org.example.youngnam.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.youngnam.domain.user.entity.User;
import org.example.youngnam.domain.user.repository.UserRepository;
import org.example.youngnam.global.exception.EntityNotFoundException;
import org.example.youngnam.global.exception.ErrorCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void putBlogId(final Long userID, final String blogId) {
        final User foundUser = userRepository.findById(userID).orElseThrow(
                () -> new EntityNotFoundException(ErrorCode.NOT_FOUND_USER)
        );
        foundUser.setNaverId(blogId);
    }
}
