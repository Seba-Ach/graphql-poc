package com.poc.graphql.resolver.authorResolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.poc.graphql.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorFieldResolver implements GraphQLResolver<AuthorDto> {

    public Integer getPostsCount(AuthorDto authorDto){
        return authorDto.getPosts().size();
    }

}
