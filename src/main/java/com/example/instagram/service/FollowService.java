package com.example.instagram.service;

import org.springframework.stereotype.Service;

@Service
public interface FollowService {
    void toggleFollow(Long followerId, String followingUsername);
}
