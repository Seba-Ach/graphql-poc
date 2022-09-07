package com.poc.graphql.dto;

import com.poc.graphql.entity.Author;

import java.util.UUID;

public class PostDto {

    private UUID id;
    private String title;
    private String content;
    private Author author;

    public PostDto(UUID id, String title, String content, Author author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Author getAuthor() {
        return author;
    }

}
