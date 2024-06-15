package com.bloggerdemoapp.gdemo.repositery;

import com.bloggerdemoapp.gdemo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}