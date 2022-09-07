package com.poc.graphql.mapper;

import com.poc.graphql.dto.PostDto;
import com.poc.graphql.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto fromPost(Post post){
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

    public static List<PostDto> fromPost(List<Post> post){
        return post.stream().map(PostMapper::fromPost).collect(Collectors.toList());
    }

    public static Post fromPostDto(PostDto postdto){
        return new Post(postdto.getId(), postdto.getTitle(), postdto.getContent(), postdto.getAuthor());
    }

    public static List<Post> fromPostDto(List<PostDto> post){
        return post.stream().map(PostMapper::fromPostDto).collect(Collectors.toList());
    }
}
