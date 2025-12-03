package com.example.instagram.service;

import com.example.instagram.dto.request.CommentRequest;
import com.example.instagram.dto.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    CommentResponse create(Long postId, CommentRequest commentCreateRequest, Long userId);
    List<CommentResponse> getComments(Long postId);
}
