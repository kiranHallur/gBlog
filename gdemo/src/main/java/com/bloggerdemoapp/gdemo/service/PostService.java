package com.bloggerdemoapp.gdemo.service;

import com.bloggerdemoapp.gdemo.dto.PostControllerDto;
import com.bloggerdemoapp.gdemo.entity.Post;
import com.bloggerdemoapp.gdemo.repositery.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {



    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //used to convert dto to entity          job of this method is supply dto obj convert it to entity and return
    Post dtoToEntity(PostControllerDto dto){
        Post entity = new Post();
        entity.setName(dto.getName());
        entity.setContent(dto.getContent());
        return entity;
    }

    //used to convert entity to dto         job of this method is give entity obj, it copies to dto and returns back dto
    PostControllerDto EntityToDto(Post en){
        PostControllerDto puo=new PostControllerDto();
        puo.setId(en.getId());
        puo.setName(en.getName());
        puo.setContent(en.getContent());
        return puo;
    }

    public PostControllerDto addPost(PostControllerDto post) {

        Post entity = dtoToEntity(post);  //dto obj came from dtoToEntity method
        Post saved = postRepository.save(entity);
        PostControllerDto puo=EntityToDto(saved);  //called the method EntityToDto, it converts entity to dto

        return puo;
    }
}
