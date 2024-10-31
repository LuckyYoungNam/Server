package org.example.youngnam.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.youngnam.domain.user.dto.UserBusinessInfoRes;
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
    public void patchBlogId(final Long userID,
                            final String name,
                            final String location,
                            final String address) {

        final User foundUser = findUserById(userID);
        foundUser.setBusinessName(name);
        foundUser.setBusinessLocation(location);
        foundUser.setBusinessAddress(address);
    }

    public UserBusinessInfoRes getUserBusinessInfo(final Long userId) {
        final User foundUser = findUserById(userId);
        return UserBusinessInfoRes.of(
                foundUser.getBusinessName(),
                foundUser.getBusinessLocation(),
                foundUser.getBusinessAddress());
    }


    private User findUserById(final Long userID) {
        return userRepository.findById(userID).orElseThrow(
                IllegalArgumentException::new
        );
    }
}
