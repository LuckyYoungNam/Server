package org.example.youngnam.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.youngnam.domain.user.dto.UserLoginRes;
import org.example.youngnam.domain.user.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(
        origins = "https://inuluckyyoungnam.vercel.app",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH}
)public class AuthController {
    private final AuthService authService;

    @PostMapping("/users/login")
    public ResponseEntity<UserLoginRes> login(@RequestHeader(HttpHeaders.AUTHORIZATION) final String authenticationCode) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(authenticationCode));
    }

}
