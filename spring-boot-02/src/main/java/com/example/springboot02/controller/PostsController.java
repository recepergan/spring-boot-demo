package com.example.springboot02.controller;

import com.example.springboot02.model.Posts;
import com.example.springboot02.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
public class PostsController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PostsRepository postsRepository;


    @GetMapping("/posts/{id}")
    public Posts getJsonFromRemotePostsList(@PathVariable int id) {
        Posts posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" +id,Posts.class);
        posts.setLocalDateTime(LocalDateTime.now());
        postsRepository.save(posts);

        return posts;
    }

    @GetMapping("/postsstr/{id}")
    public ResponseEntity<String> getJsonFromRemotePostsListWithString(@PathVariable int id) {
        ResponseEntity<String> postsStr = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/" +id,String.class);

        return postsStr;
    }


}
