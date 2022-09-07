package com.poc.graphql.resolver.authorResolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.poc.graphql.dto.AuthorDto;
import com.poc.graphql.entity.Author;
import com.poc.graphql.mapper.AuthorMapper;
import com.poc.graphql.service.AuthorService;
import org.springframework.stereotype.Component;

import java.util.Optional;
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

    public AuthorDto getAuthorById(UUID id){
        Optional<Author> authorById = authorService.getAuthorById(id);
        if(!authorById.isPresent()){
            return null;
        }

        return AuthorMapper.fromAuthor(authorById.get());
    }

}
