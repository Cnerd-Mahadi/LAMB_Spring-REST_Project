package com.controllers;

import com.models.Post;
import com.services.PostService;
import com.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend")
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final UserController userController;

    public PostController(PostService postService, UserService userService, UserController userController) {
        this.postService = postService;
        this.userService = userService;
        this.userController = userController;
    }

    @RequestMapping(value = "/create-post", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Post> makePost(@RequestBody Post post) {

        postService.save(post);
        return ResponseEntity.ok(post);
    }

    @RequestMapping(value= "/get-post/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("id") Integer id) {
        return postService.get(id);
    }

    @RequestMapping(value = "/get-all-post-user", method = RequestMethod.GET)
    public List<Post> getAllPostByUser(ServletRequest servletRequest) {
        return postService.getPostByUser(userController.getUser(servletRequest).getUserId());
    }

    @RequestMapping(value = "/get-all-post", method = RequestMethod.GET)
    public List<Post> showAllPost() {
        return postService.getAll();
    }

    @RequestMapping(value = "/delete-post/{id}", method = RequestMethod.GET)
    public ResponseEntity deletePost(@PathVariable("id") Integer id) {
        postService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/update-post", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {

        postService.update(post);
        return ResponseEntity.ok(post);
    }

    @RequestMapping(value = "/update-last-status", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Post> updateLastStatus(@RequestBody Post post) {
        postService.updateLastStatus(post);
        return ResponseEntity.ok(post);
    }





}
