package com.arjun.SpringData_JobPortal.controller;

import com.arjun.SpringData_JobPortal.model.User;
import com.arjun.SpringData_JobPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("register")
    public User createUser(@RequestBody User user){
        return service.saveUser(user);
    }
}
