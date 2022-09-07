package com.poc.graphql.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Type(type = "uuid-char")
    private UUID id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Post> posts;

    public Author() {
    }

    public Author(UUID id, String name, String email, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.posts = posts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
