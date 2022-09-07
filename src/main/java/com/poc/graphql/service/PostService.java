package com.poc.graphql.service;

import com.poc.graphql.dto.PostDto;
import com.poc.graphql.entity.Post;
import com.poc.graphql.mapper.PostMapper;
import com.poc.graphql.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDto> getAllPostOfAuthor(UUID authorId) {
        return PostMapper.fromPost(postRepository.findAllByAuthor_Id(authorId));
    }

    public List<PostDto> recentPosts(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Post> pagePosts = postRepository.findAll(pageable);
        return pagePosts.stream().map(PostMapper::fromPost).collect(Collectors.toList());
    }
}
