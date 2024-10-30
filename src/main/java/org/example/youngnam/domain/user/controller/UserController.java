package org.example.youngnam.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.youngnam.auth.resolver.UserId;
import org.example.youngnam.domain.user.dto.UserBlogIdReq;
import org.example.youngnam.domain.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/blog")
    public ResponseEntity<Void> putUserBlogId(@UserId final Long userId,
                                              @RequestBody final UserBlogIdReq userBlogIdReq) {
        userService.putBlogId(userId, userBlogIdReq.blogId());
        return ResponseEntity.ok().build();
    }
}
