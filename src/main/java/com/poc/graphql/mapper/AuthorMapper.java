package com.poc.graphql.mapper;

import com.poc.graphql.dto.AuthorDto;
import com.poc.graphql.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {

    public static AuthorDto fromAuthor(Author author) {
        return AuthorDto.withBuilder()
                .withId(author.getId())
                .withEmail(author.getEmail())
                .withName(author.getName())
                .withPosts(PostMapper.fromPost(author.getPosts()))
                .build();
    }

    public static List<AuthorDto> fromAuthor(List<Author> author) {
        return author.stream().map(AuthorMapper::fromAuthor).collect(Collectors.toList());
    }

    public static Author fromAuthorDto(AuthorDto author) {
        return new Author(author.getId(), author.getName(), author.getEmail(), PostMapper.fromPostDto(author.getPosts()));
    }

}
