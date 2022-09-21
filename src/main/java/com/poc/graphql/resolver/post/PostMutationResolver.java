package com.poc.graphql.resolver.post;

import com.poc.graphql.dto.PostDto;
import com.poc.graphql.dto.request.CreatePostRequest;
import com.poc.graphql.service.PostPublisherService;
import com.poc.graphql.service.PostService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class PostMutationResolver implements GraphQLMutationResolver {

    private final PostService postService;
    private final PostPublisherService postPublisherService;

    public PostMutationResolver(PostService postService, PostPublisherService postPublisherService) {
        this.postService = postService;
        this.postPublisherService = postPublisherService;
    }

    public PostDto createPost(CreatePostRequest createPostRequest) {
        PostDto post = postService.createPost(createPostRequest);

        postPublisherService.publish(post);

        return post;
    }

}
