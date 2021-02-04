package com.example.oauth.application.dto;

import com.example.oauth.domain.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponse {
    private final Long id;
    private final Integer githubId;
    private final String login;
    private final String avatarUrl;

    private UserResponse() {
        this(null, null, null, null);
    }

    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getGithubId(), user.getLogin(), user.getAvatarUrl());
    }
}
