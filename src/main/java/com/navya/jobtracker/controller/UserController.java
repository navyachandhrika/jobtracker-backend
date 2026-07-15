package com.navya.jobtracker.controller;

import com.navya.jobtracker.entity.User;
import com.navya.jobtracker.security.JwtUtil;
import com.navya.jobtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> loggedInUser =
                userService.login(user.getEmail(), user.getPassword());

        if (loggedInUser.isPresent()) {
            return jwtUtil.generateToken(user.getEmail());
        }

        return "Invalid Email or Password";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody User user) {

        return userService.forgotPassword(
                user.getEmail(),
                user.getPassword()
        );
    }
}