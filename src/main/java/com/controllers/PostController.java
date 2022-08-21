package com.controllers;

import com.models.Post;
import com.models.User;
import com.services.PostService;
import com.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity makePost(@RequestBody Post post, ServletRequest servletRequest) {
        post.setUserFK(userController.getUser(servletRequest).getUserId());
        postService.save(post);
        User user = userService.get(post.getUserFK());
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("post", post);
        data.put("user", user);
        return ResponseEntity.ok(data);
    }

    @RequestMapping(value= "/get-post/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("id") Integer id) {
        return postService.get(id);
    }

    @RequestMapping(value = "/get-all-post-user", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllPostByUser(ServletRequest servletRequest) {
        int userId = userController.getUser(servletRequest).getUserId();
        List<Post> posts = postService.getPostByUser(userId);
        List<Map<String, Object>> allData = new ArrayList<Map<String, Object>>();
        Map<String, Object> data = new HashMap<String, Object>();
        for (Post post: posts) {
            User user = userService.get(post.getUserFK());
            data.put("post", post);
            data.put("user", user);
            allData.add(data);
        }
        return allData;
    }

    @RequestMapping(value = "/get-all-post", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllPost() {
        List<Post> posts = postService.getAll();
        List<Map<String, Object>> allData = new ArrayList<Map<String, Object>>();
        Map<String, Object> data = new HashMap<String, Object>();
        for (Post post: posts) {
            User user = userService.get(post.getUserFK());
            data.put("post", post);
            data.put("user", user);
            allData.add(data);
        }

        return allData;
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
