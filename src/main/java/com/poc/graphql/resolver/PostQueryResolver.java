package com.poc.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.poc.graphql.dto.PostDto;
import com.poc.graphql.service.PostService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostQueryResolver implements GraphQLQueryResolver {

    private final PostService postService;

    public PostQueryResolver(PostService postService) {
        this.postService = postService;
    }

    public List<PostDto> recentPosts(int page, int count){
        return postService.recentPosts(page, count);
    }

}
