package com.bloggerdemoapp.gdemo.controller;

import com.bloggerdemoapp.gdemo.dto.CommentControllerDto;
import com.bloggerdemoapp.gdemo.entity.Comment;
import com.bloggerdemoapp.gdemo.entity.Post;
//import com.bloggerdemoapp.gdemo.repository.PostRepository;
import com.bloggerdemoapp.gdemo.repositery.PostRepository;
import com.bloggerdemoapp.gdemo.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;  //for service layer
    private final PostRepository postRepository;  //we are using foreign key as post_id, and we need nested obj in postAPI

    public CommentController(CommentService commentService, PostRepository postRepository) {
        this.commentService = commentService;
        this.postRepository = postRepository;
    }

    @PostMapping
    public ResponseEntity<CommentControllerDto> createComment(
            @RequestParam long postId,
            @RequestBody CommentControllerDto commentDto
    ) {
        Optional<Post> postOptional = postRepository.findById(postId);  //passing parm as postId, bcz we need foreign key to add th table
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            commentDto.setPost(post);
            CommentControllerDto savedCommentDto = commentService.addComment(postId, commentDto);
            return new ResponseEntity<>(savedCommentDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
