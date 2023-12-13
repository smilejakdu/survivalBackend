package com.ahastudio.api.rest.demo.controllers;

import com.ahastudio.api.rest.demo.dtos.PostDto;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private ObjectMapper objectMapper;

    public PostController(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<PostDto> list() {
        List<PostDto> postDtos = List.of(
                new PostDto("1","제목","테스트입니다."),
                new PostDto("2","제목_two","테스트입니다_two.")
        );
        return postDtos;
    }

    @GetMapping("/{id}")
    public String detail(
            @PathVariable String id
    ) throws JacksonException {
        PostDto postDto = new PostDto("1234","title","테스트입니다.");
        return objectMapper.writeValueAsString(postDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(
            @RequestBody PostDto postDto
    ) {
        return postDto;
    }

    @PatchMapping("/{id}")
    public PostDto update(
            @PathVariable String id,
            @RequestBody PostDto postDto
    ) {
        postDto.setId(id);
        return postDto;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return "delete post " + id;
    }
}
