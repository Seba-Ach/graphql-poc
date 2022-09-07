package com.poc.graphql.resolver.author;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.poc.graphql.dto.AuthorDto;
import com.poc.graphql.dto.request.CreateAuthorRequest;
import com.poc.graphql.mapper.AuthorMapper;
import com.poc.graphql.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final AuthorService authorService;

    public AuthorMutationResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public AuthorDto createAuthor(CreateAuthorRequest authorRequest){
        return AuthorMapper.fromAuthor(authorService.createAuthor(authorRequest));
    }

}
