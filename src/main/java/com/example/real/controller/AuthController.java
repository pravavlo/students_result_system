package com.example.real.controller;


import com.example.real.DTO.JwtRequest;
import com.example.real.DTO.JwtResponse;
import com.example.real.constants.PathConstant;
import com.example.real.entity.User;
import com.example.real.service.Impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostConstruct
    public void initRoleAndUser() {
        authService.initRoleAndUser();
    }

    @PostMapping({PathConstant.REGISTRATION})
    public User registerNewUser(@RequestBody User user) throws Exception {
        return authService.registerNewUser(user);
    }

    @PostMapping(PathConstant.LOGIN)
    public JwtResponse login(@RequestBody JwtRequest jwtRequest) throws Exception {
        return authService.createJwtToken(jwtRequest);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('ADMIN')")
    public String forAdmin(){
        return "This page is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('USER')")
    public String forUser(){
        return "This page is only accessible to the user";
    }
}