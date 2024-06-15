package com.bloggerdemoapp.gdemo.service;

import com.bloggerdemoapp.gdemo.dto.CommentControllerDto;
import com.bloggerdemoapp.gdemo.entity.Comment;
//import com.bloggerdemoapp.gdemo.repository.CommentRepository;
import com.bloggerdemoapp.gdemo.repositery.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    private Comment dtoToEntity(CommentControllerDto dto) {
        Comment entity = new Comment();
        entity.setEmail(dto.getEmail());
        entity.setContent(dto.getContent());
        entity.setPost(dto.getPost());
        return entity;
    }

    private CommentControllerDto entityToDto(Comment entity) {
        CommentControllerDto dto = new CommentControllerDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setContent(entity.getContent());
        dto.setPost(entity.getPost());
        return dto;
    }

    public CommentControllerDto addComment(long postId, CommentControllerDto commentDto) {
        Comment entity = dtoToEntity(commentDto);
        Comment savedComment = commentRepository.save(entity);
        return entityToDto(savedComment);
    }
}
