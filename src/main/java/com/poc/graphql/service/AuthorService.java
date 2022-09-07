package com.poc.graphql.service;

import com.poc.graphql.dto.AuthorDto;
import com.poc.graphql.dto.CreateAuthorRequest;
import com.poc.graphql.entity.Author;
import com.poc.graphql.mapper.AuthorMapper;
import com.poc.graphql.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDto getAuthorByName(String name) {
        return AuthorMapper.fromAuthor(authorRepository.findAuthorByName(name));
    }

    public Optional<Author> getAuthorById(UUID id) {
        return authorRepository.findById(id);
    }

    public Author createAuthor(CreateAuthorRequest authorRequest){
        Author author = new Author(UUID.randomUUID(), authorRequest.getName(), authorRequest.getEmail(), Collections.emptyList());
        return authorRepository.save(author);
    }


}
