package com.poc.graphql.service;

import com.poc.graphql.dto.AuthorDto;
import com.poc.graphql.dto.request.CreateAuthorRequest;
import com.poc.graphql.entity.Author;
import com.poc.graphql.exceptions.ResourceNotFound;
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
        Optional<Author> authorByName = authorRepository.findAuthorByName(name);

        if(!authorByName.isPresent()){
            throw new ResourceNotFound("Author with name " + name + " not found");
        }

        return AuthorMapper.fromAuthor(authorByName.get());
    }

    public AuthorDto getAuthorById(UUID id) {
        Optional<Author> authorById = authorRepository.findById(id);

        if(!authorById.isPresent()){
            return null;
        }

        return AuthorMapper.fromAuthor(authorById.get());
    }

    public Author createAuthor(CreateAuthorRequest authorRequest){
        Author author = new Author(UUID.randomUUID(), authorRequest.getName(), authorRequest.getEmail(), Collections.emptyList());
        return authorRepository.save(author);
    }


}
