package com.controllers;

import com.models.Post;
import com.services.PostService;
import com.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backend")
public class VisitorController {

    private final UserService userService;
    private final PostService postService;
    public VisitorController(UserService userService, PostService postService) {

        this.userService = userService;
        this.postService = postService;
    }





}
