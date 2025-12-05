package com.example.instagram.repository;

import com.example.instagram.dto.response.PostResponse;
import com.example.instagram.entity.Post;
import com.example.instagram.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUserIdOrderByCreatedAtDesc(Long userId);

    List<Post> findAllByOrderByCreatedAtDesc();

    long countByUserId(Long userId);

    // 피드조회
    @Query("SELECT p FROM Post p JOIN FETCH p.user WHERE p.user.id IN :userIds ORDER BY p.createdAt DESC")
    Slice<Post> findFeedPostsByUserIds(@Param("userIds") List<Long> userIds, Pageable pageable);

    // 게시물 조회 (페이징)
    @Query("SELECT p FROM Post p JOIN FETCH p.user ORDER BY p.createdAt DESC")
    Slice<Post> findAllWithUserPaging(Pageable pageable);

    @Query("SELECT p FROM Post p JOIN FETCH p.user WHERE p.content LIKE %:keyword% ORDER BY p.createdAt DESC")
    Slice<Post> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
