package com.poc.graphql.dto.request;

import java.util.UUID;

public class CreatePostRequest {

    private String title;
    private String content;
    private UUID author_Id;

    public CreatePostRequest() {
    }

    public CreatePostRequest(String title, String content, UUID author_Id) {
        this.title = title;
        this.content = content;
        this.author_Id = author_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getAuthor_Id() {
        return author_Id;
    }

    public void setAuthor_Id(UUID author_Id) {
        this.author_Id = author_Id;
    }
}
