package com.poc.graphql.resolver.author;

import com.poc.graphql.dto.AuthorDto;
import com.poc.graphql.service.AuthorService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorService authorService;

    public AuthorQueryResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public AuthorDto getAuthor(String name) {
        return authorService.getAuthorByName(name);
    }

    public AuthorDto getAuthorById(UUID id) {
        return authorService.getAuthorById(id);
    }

}
