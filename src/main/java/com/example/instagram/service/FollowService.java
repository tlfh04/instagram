package com.example.instagram.service;

import org.springframework.stereotype.Service;

@Service
public interface FollowService {
    void toggleFollow(Long followerId, String followingUsername);

    boolean isFollowing(Long followerId, Long followingId);

    long countByFollowerId(Long followerId);
    long countByFollowingId(Long followingId);
}
