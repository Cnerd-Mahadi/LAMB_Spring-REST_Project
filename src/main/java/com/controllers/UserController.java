package com.controllers;

import com.configs.jwt.JwtFilter;
import com.configs.jwt.JwtProvider;
import com.models.AuthRequest;
import com.models.AuthResponse;
import com.models.Donor;
import com.models.User;
import com.services.DonorService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend")
public class UserController {

    private final UserService userService;
    private final DonorService donorService;
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserController(UserService userService, DonorService donorService) {
        this.userService = userService;
        this.donorService = donorService;
    }

    @RequestMapping(value = "/get-unique-check", method = RequestMethod.GET)
    public List<User> doRegistration() {

        return userService.uniqueCheckMaterials();

    }

//    @RequestMapping(value = "/log", method = RequestMethod.POST, consumes = {"application/json"})
//    public String doR(@RequestBody AuthRequest request) {
//
//        User user = userService.getWithCredByEmail(request.getLogin());
//
//        //return ;
//        if(passwordEncoder.matches(request.getPassword(), user.getPassword()))
//            return "MATCHED";
//        return "NOT MATCHED";
//
//
//       // return userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
//
//    }

    @RequestMapping(value = "/login-user", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity auth(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        if(user == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
        String token = jwtProvider.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @RequestMapping(value = "/save-user", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity doRegistration(@RequestBody Map<String,String> data) {

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
            donor.setUserFK(user.getUserId());
            donorService.save(donor);
        }

        String token = jwtProvider.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @RequestMapping("/get-user")
    public User getUser(ServletRequest servletRequest) {
        return jwtFilter.extractUser(servletRequest);
    }


    @RequestMapping(value = "/update-user", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<User> update(@RequestBody User user, ServletRequest servletRequest) {
        user.setUserId(jwtFilter.extractUser(servletRequest).getUserId());
        userService.update(user);
        return ResponseEntity.ok(user);
    }

//    @RequestMapping("/delete-user")
//    public String delete(@RequestParam("userId") int id) {
//        userService.delete(id);
//        return "redirect:/user/list";
//    }

}
