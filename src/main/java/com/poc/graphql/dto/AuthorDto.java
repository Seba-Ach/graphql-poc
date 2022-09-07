package com.poc.graphql.dto;

import java.util.List;
import java.util.UUID;


public class AuthorDto {

    private UUID id;
    private String name;
    private String email;
    private List<PostDto> posts;

    private AuthorDto(UUID id, String name, String email, List<PostDto> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.posts = posts;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public static Builder withBuilder(){
        return new Builder();
    }

    public static class Builder{

        private UUID id;
        private String name;
        private String email;
        private List<PostDto> posts;

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPosts(List<PostDto> posts) {
            this.posts = posts;
            return this;
        }

        public AuthorDto build(){
            return new AuthorDto(id, name, email, posts);
        }

    }

}
