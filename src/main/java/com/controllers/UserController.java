package com.controllers;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.models.User;
import com.services.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public List<User> list(Model model, @RequestParam(required = false) String sortKey) {
        return userService.getAll();
    }

    @RequestMapping("/list/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {"application/json"})
    public String create(@RequestBody Map<String,String> data) {
        User user = new User();
        user.setUsername(data.get("username"));
        user.setEmail(data.get("email"));
        user.setPassword(data.get("password"));
        user.setRole(data.get("role"));
        user.setPhone(data.get("phone"));
        userService.save(user);
        return "Data Saved Successfully";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String userUpdateForm(@RequestParam("userId") int id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "update-user-form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userId") int id) {
        userService.delete(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/search")
    public String delete(@RequestParam("searchValue") String firstname, Model model) {
        List<User> users = userService.getAll(firstname);
        model.addAttribute("users", users);
        return "user-list";
    }
}
