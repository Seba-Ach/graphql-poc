package com.poc.graphql.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Type(type = "uuid-char")
    private UUID id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Post() {
    }

    public Post(UUID id, String title, String content, Author author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
