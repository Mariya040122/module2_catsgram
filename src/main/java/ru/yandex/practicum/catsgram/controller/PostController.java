package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/{postId}")
    public Post findById(@PathVariable int postId) {
        return postService.findAll(0,"asc",1).stream()
                .filter(x -> x.getId() == postId)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/posts")
    public List<Post> findAll(@RequestParam(defaultValue = "asc") String sort,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(defaultValue = "1") int page) {
        return postService.findAll(size, sort, ((page - 1) * size));
    }

    @PostMapping(value = "/posts")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }


}