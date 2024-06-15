package com.bloggerdemoapp.gdemo.repositery;

import com.bloggerdemoapp.gdemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}