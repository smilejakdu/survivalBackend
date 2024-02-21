package com.ahastudio.api.rest.demo.services;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.exceptions.PostNotFound;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PostService {
    // PostDTO
    private List<PostDto> postDtos = new ArrayList<>(List.of(
            new PostDto("1", "title1", "content1"),
            new PostDto("2", "title2", "2등 입니다.")
    ));

    public PostDto getPostDtos(String id) {
        return findPostDto(id);
    }

    private PostDto findPostDto(String id) {
        return postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public PostDto getPostDto(String id) {
        return postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public PostDto createPost(PostDto postDto) {
        // TODO: 원본을 고치지 말것
        PostDto created = new PostDto(
                String.valueOf(postDtos.size() + 1),
                postDto.getTitle(),
                postDto.getContent()
        );
        postDtos.add(created);
        return created;
    }

    public PostDto updatePost(String id, PostDto postDto) {
        PostDto found = findPostDto(id);
        // TODO: 별로지만 일단 한다.
        found.setTitle(postDto.getTitle());
        found.setContent(postDto.getContent());
        return found;
    }

    public PostDto deletePost(Long id) {
        return postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
