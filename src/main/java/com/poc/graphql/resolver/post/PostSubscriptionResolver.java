package com.poc.graphql.resolver.post;

import com.poc.graphql.dto.PostDto;
import com.poc.graphql.service.PostPublisherService;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PostSubscriptionResolver implements GraphQLSubscriptionResolver {

    private final PostPublisherService postPublisherService;

    public PostSubscriptionResolver(PostPublisherService postPublisherService) {
        this.postPublisherService = postPublisherService;
    }

    public Publisher<PostDto> recentPost() {
        return postPublisherService.getRecentPost();
    }

}
