package com.example.real.controller;

import com.example.real.constants.PathConstant;
import com.example.real.entity.Role;

import com.example.real.service.Impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(PathConstant.ADD_ROLE)
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}