package org.example.youngnam.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.youngnam.domain.user.dto.UserLoginRes;
import org.example.youngnam.domain.user.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("users/login")
    public ResponseEntity<UserLoginRes> login(@RequestHeader(HttpHeaders.AUTHORIZATION) final String authenticationCode) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(authenticationCode));
    }

}
