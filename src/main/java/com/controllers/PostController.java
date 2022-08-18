package com.controllers;

import com.models.Donor;
import com.models.Post;
import com.models.User;
import com.services.DonorService;
import com.services.PostService;
import com.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping(value = "/create-post", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Post> makePost(@RequestBody Post post) {

        postService.save(post);
        return ResponseEntity.ok(post);
    }



}
