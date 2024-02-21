package com.ahastudio.api.rest.demo.controllers;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.ahastudio.api.rest.demo.services.PostService;
import com.fasterxml.jackson.core.JacksonException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController() {
        postService = new PostService();
    }

    @GetMapping
    public PostDto list(
            @PathVariable String id
    ) {
        return postService.getPostDtos(id);
    }

    @GetMapping("/{id}")
    public PostDto detail(
            @PathVariable String id
    ) throws JacksonException {
        return postService.getPostDto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(
            @RequestBody PostDto postDto
    ) {
        return postService.createPost(postDto);
    }

    @PatchMapping("/{id}")
    public PostDto update(
            @PathVariable String id,
            @RequestBody PostDto postDto
    ) {
        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
