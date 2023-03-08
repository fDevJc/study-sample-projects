package com.jc.rediscachesample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jc.rediscachesample.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
