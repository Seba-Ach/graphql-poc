package com.poc.graphql.service;

import com.poc.graphql.dto.AuthorDto;
import com.poc.graphql.dto.PostDto;
import com.poc.graphql.dto.request.CreatePostRequest;
import com.poc.graphql.entity.Author;
import com.poc.graphql.entity.Post;
import com.poc.graphql.mapper.AuthorMapper;
import com.poc.graphql.mapper.PostMapper;
import com.poc.graphql.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final AuthorService authorService;

    public PostService(PostRepository postRepository, AuthorService authorService) {
        this.postRepository = postRepository;
        this.authorService = authorService;
    }

    public List<PostDto> getAllPostOfAuthor(UUID authorId) {
        return PostMapper.fromPost(postRepository.findAllByAuthor_Id(authorId));
    }

    public List<PostDto> recentPosts(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Post> pagePosts = postRepository.findAll(pageable);
        return pagePosts.stream().map(PostMapper::fromPost).collect(Collectors.toList());
    }

    public PostDto createPost(CreatePostRequest createPostRequest) {
        AuthorDto authorById = authorService.getAuthorById(createPostRequest.getAuthor_Id());

        Post post = Post.newBuilder()
                .withTitle(createPostRequest.getTitle())
                .withContent(createPostRequest.getContent())
                .withAuthor(AuthorMapper.fromAuthorDto(authorById))
                .build();

        return PostMapper.fromPost(postRepository.save(post));
    }
}
