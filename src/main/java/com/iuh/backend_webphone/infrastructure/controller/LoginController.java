package com.iuh.backend_webphone.infrastructure.controller;

import com.iuh.backend_webphone.application.iservice.IUserService;
import com.iuh.backend_webphone.domain.entity.User;
import com.iuh.backend_webphone.infrastructure.configuration.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/authenticate")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User authenticatedUser = userService.getUserByUserNameAndPassWord(user.getUsername(), user.getPassword());
        String token = jwtUtil.generateToken(authenticatedUser.getUsername(), authenticatedUser.getRole());
        return token;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.createUser(user);
        return "User registered successfully";
    }
}
