package org.example.youngnam.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.youngnam.auth.resolver.UserId;
import org.example.youngnam.domain.user.dto.UserBusinessInfoReq;
import org.example.youngnam.domain.user.dto.UserBusinessInfoRes;
import org.example.youngnam.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PatchMapping("/users/info")
    public ResponseEntity<Void> postBusinessInfo(@UserId final Long userId,
                                              @RequestBody final UserBusinessInfoReq userBusinessInfoReq) {
        userService.patchBlogId(userId, userBusinessInfoReq.name(), userBusinessInfoReq.location(), userBusinessInfoReq.address());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/info")
    public ResponseEntity<UserBusinessInfoRes> postBusinessInfo(@UserId final Long userId) {
        final UserBusinessInfoRes userBusinessInfoRes = userService.getUserBusinessInfo(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userBusinessInfoRes);
    }
}
