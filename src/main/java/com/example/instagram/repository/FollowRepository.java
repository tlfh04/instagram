package com.example.instagram.repository;

import com.example.instagram.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FollowRepository extends JpaRepository<Follow, Long> {

}
