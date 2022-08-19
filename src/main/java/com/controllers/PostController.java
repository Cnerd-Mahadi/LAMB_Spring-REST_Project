package com.controllers;

import com.models.Donor;
import com.models.Post;
import com.models.User;
import com.services.DonorService;
import com.services.PostService;
import com.services.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend")
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

    @RequestMapping(value= "/get-post/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("id") Integer id) {
        return postService.get(id);
    }

    @RequestMapping(value = "/get-all-post-user/{userid}", method = RequestMethod.GET)
    public List<Post> getAllPostByUser(@PathVariable("userid") Integer userid) {
        return postService.getPostByUser(userid);
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
