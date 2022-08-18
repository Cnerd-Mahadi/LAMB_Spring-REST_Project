package com.controllers;

import com.models.Donor;
import com.models.User;
import com.services.DonorService;
import com.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final DonorService donorService;

    public UserController(UserService userService, DonorService donorService) {
        this.userService = userService;
        this.donorService = donorService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public List<User> doRegistration() {

        return userService.uniqueCheckMaterials();

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<User> doRegistration(@RequestBody Map<String,String> data) {

        User user = new User();
        user.setUsername(data.get("username"));
        user.setEmail(data.get("email"));
        user.setPassword(data.get("password"));
        user.setRole(data.get("role"));
        user.setPhone(data.get("phone"));
        user.setArea(data.get("area"));
        userService.save(user);

        if(user.getRole().equals("donor")) {

            Donor donor = new Donor();
            donor.setEligibility(data.get("eligibility"));
            donor.setLastDonate(data.get("last_donate"));
            donor.setBloodType(data.get("blood_type"));
            donor.setDonorUserInfo(user);
            user.setDonorInfo(donor);
            donorService.save(user.getDonorInfo());
        }

        return ResponseEntity.ok(user);
    }

    @RequestMapping("/list")
    public List<User> list(Model model, @RequestParam(required = false) String sortKey) {
        return userService.getAll();
    }

    @RequestMapping("/list/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.get(id);
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
