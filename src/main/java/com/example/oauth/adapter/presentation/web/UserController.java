package com.example.oauth.adapter.presentation.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oauth.application.UserService;
import com.example.oauth.application.dto.UserResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService service;

    @GetMapping("/user")
    public ResponseEntity<UserResponse> user(@AuthenticationPrincipal OAuth2User principal) {
        String githubId = principal.getAttribute("id");
        String login = principal.getAttribute("login");
        String avatarUrl = principal.getAttribute("avatar_url");

        UserResponse saved = service.save(githubId, login, avatarUrl);
        return ResponseEntity.created(URI.create("/user/" + saved.getId())).body(saved);
    }
}
