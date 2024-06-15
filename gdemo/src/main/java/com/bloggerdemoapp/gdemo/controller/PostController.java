package com.bloggerdemoapp.gdemo.controller;

import com.bloggerdemoapp.gdemo.dto.PostControllerDto;
import com.bloggerdemoapp.gdemo.entity.Post;
import com.bloggerdemoapp.gdemo.repositery.PostRepository;
import com.bloggerdemoapp.gdemo.service.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private PostService ps;
    //private final PostRepository postRepository;

    public PostController(PostService ps,
                          PostRepository postRepository) {
        this.ps = ps;
        //this.postRepository = postRepository;
    }

    @PostMapping
    public ResponseEntity<PostControllerDto> createPost(@RequestBody PostControllerDto post){
        PostControllerDto postControllerDto = ps.addPost(post);
        return new ResponseEntity<>(postControllerDto, HttpStatus.CREATED);
    }
}
