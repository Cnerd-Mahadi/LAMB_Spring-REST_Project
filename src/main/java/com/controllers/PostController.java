package com.controllers;

import com.models.Donor;
import com.models.Post;
import com.models.User;
import com.services.DonorService;
import com.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/create-post", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Post> makePost(@RequestBody Post post) {

        postService.save(post);
        return ResponseEntity.ok(post);
    }



}
