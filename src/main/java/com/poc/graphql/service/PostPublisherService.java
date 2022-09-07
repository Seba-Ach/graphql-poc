package com.poc.graphql.service;

import com.poc.graphql.dto.PostDto;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class PostPublisherService {

    private final Sinks.Many<PostDto> processor;

    public PostPublisherService() {
        this.processor = Sinks.many().replay().all();
    }

    public Publisher<PostDto> getRecentPost(){
        return processor.asFlux();
    }

    public void publish(PostDto post){
        processor.emitNext(post, Sinks.EmitFailureHandler.FAIL_FAST);
    }

}
