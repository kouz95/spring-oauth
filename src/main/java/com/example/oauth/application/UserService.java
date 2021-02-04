package com.example.oauth.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.oauth.application.dto.UserResponse;
import com.example.oauth.domain.model.User;
import com.example.oauth.domain.model.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;

    @Transactional
    public UserResponse save(String githubId, String login, String avatarUrl) {
        User saved = repository.save(new User(null, githubId, login, avatarUrl));
        return UserResponse.from(saved);
    }
}
